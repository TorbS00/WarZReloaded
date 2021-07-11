package com.github.beastyboo.foundation;

import java.util.concurrent.CompletableFuture;

public interface TransactionExecutor {
    @FunctionalInterface
    interface TransactionRunner {

        void runTransactUsing(Transaction transaction);
    }

    @FunctionalInterface
    interface TransactionActor<R> {

        R transactUsing(Transaction transaction);
    }

    /**
     *  Runs a transaction without a return.
     *
     * @return a future implementation (CompletableFuture) once the transaction is complete
     */
    CompletableFuture<?> runTransaction();

    /**
     *  Runs the transaction with a return.
     *
     * @param <R> the result type
     * @return a future implementation (CompletableFuture) once the transaction is complete, yielding the transaction result
     */
    <R> CompletableFuture<R> transaction();
}
