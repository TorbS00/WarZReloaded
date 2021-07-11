package com.github.beastyboo.data;

import java.util.concurrent.CompletableFuture;

public interface TransactionExecutor {

    /**
     *  Runs a transaction.
     *
     * @return a future implementation (CompletableFuture) once the transaction is complete
     */
    CompletableFuture<?> runTransaction();

}
