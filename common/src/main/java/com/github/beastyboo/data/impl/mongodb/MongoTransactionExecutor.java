package com.github.beastyboo.data.impl.mongodb;

import com.github.beastyboo.data.TransactionExecutor;
import com.github.beastyboo.foundation.exception.UncheckedMongoException;
import com.mongodb.MongoException;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.TransactionBody;
import org.bson.Document;

import java.util.concurrent.CompletableFuture;

public class MongoTransactionExecutor implements TransactionExecutor, AutoCloseable {

    private final MongoTransaction transaction;
    private final String json;
    private final ClientSession session;

    public MongoTransactionExecutor(MongoTransaction transaction, String json) {
        this.transaction = transaction;
        this.json = json;
        this.session = transaction.getClient().startSession();
    }

    @Override
    public CompletableFuture<?> runTransaction() {
        return CompletableFuture.runAsync(() -> {
            TransactionBody txnBody = (TransactionBody<String>) () -> {
                MongoCollection<Document> collection = transaction.getDatabase().getCollection(transaction.getCollection().toString());
                collection.insertOne(session, Document.parse(json));
                return "Completed";
            };
            try {
                session.withTransaction(txnBody);
            } catch (MongoException ex) {
                throw new UncheckedMongoException(ex);
            }
        });
    }



    @Override
    public void close() throws Exception {
        session.close();
    }
}
