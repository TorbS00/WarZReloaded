package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.impl.MongoConnection;
import com.mongodb.MongoException;
import com.mongodb.client.ClientSession;

import java.util.concurrent.CompletableFuture;

public class MongoTransactionCompleter implements TransactionExecutor, AutoCloseable{

    private final MongoConnection connection;
    private final ClientSession session;

    public MongoTransactionCompleter(MongoConnection connection) {
        this.connection = connection;
        this.session = connection.getClient().startSession();
    }

    @Override
    public CompletableFuture<?> runTransaction() {
        return CompletableFuture.runAsync(() -> {
            try {
                session.withTransaction(connection.getTransactionBody());
            } catch (RuntimeException ex) {
                try {
                    session.abortTransaction();
                } catch (MongoException suppressed) {
                    ex.addSuppressed(suppressed);
                }
            }
        });
    }

    @Override
    public <R> CompletableFuture<R> transaction() {
        return  CompletableFuture.supplyAsync(() -> {
            try {
                session.withTransaction(connection.getTransactionBody());
            } catch (RuntimeException ex) {
                try {
                    session.abortTransaction();
                } catch (MongoException suppressed) {
                    ex.addSuppressed(suppressed);
                }
            }
            //TODO: Fix setup
            return null;
        });
    }

    @Override
    public void close() throws Exception {
        session.close();
    }
}
