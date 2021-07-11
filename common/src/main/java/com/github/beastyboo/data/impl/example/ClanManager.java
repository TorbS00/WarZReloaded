package com.github.beastyboo.data.impl.example;

import com.github.beastyboo.data.StorageObject;
import com.github.beastyboo.data.Transaction;
import com.github.beastyboo.data.TransactionExecutor;
import com.github.beastyboo.data.impl.mongodb.MongoConnection;
import com.github.beastyboo.data.impl.mongodb.MongoTransaction;
import com.github.beastyboo.data.impl.mongodb.MongoTransactionExecutor;
import com.google.gson.Gson;
import com.mongodb.client.MongoClients;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClanManager {

        private final Map<Integer, Clan> clans = new ConcurrentHashMap<>();
        private final MongoConnection connection = new MongoConnection(MongoClients.create("URI_EXAMPLE"));

        public record Clan(int id, int maxPlayers) implements StorageObject {};

        public void createClan(Transaction transaction, int id, int maxPlayers) {
                MongoTransaction mongoTransaction = (MongoTransaction) transaction;
                Clan clan = new Clan(id, maxPlayers);
                Gson gson = new Gson();
                String json = gson.toJson(clan);

                TransactionExecutor executor = new MongoTransactionExecutor(mongoTransaction, json);
                executor.runTransaction();
        }



        public void caller() {
                createClan(connection.transactionFactory("dev", CollectionEnum.CLAN), 5, 5);
        }



}
