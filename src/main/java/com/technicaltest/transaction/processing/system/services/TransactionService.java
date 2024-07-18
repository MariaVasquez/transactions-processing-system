package com.technicaltest.transaction.processing.system.services;

import com.technicaltest.transaction.processing.system.models.documents.Transactions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Mono<Transactions> saveTransaction(Transactions transaction);
    Flux<Transactions> getAllTransactions();
}
