package com.technicaltest.transaction.processing.system.dao;

import com.technicaltest.transaction.processing.system.models.documents.Transactions;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionDao extends ReactiveMongoRepository<Transactions, String> {
}
