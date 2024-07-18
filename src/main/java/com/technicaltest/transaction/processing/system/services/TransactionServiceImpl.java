package com.technicaltest.transaction.processing.system.services;

import com.technicaltest.transaction.processing.system.dao.TransactionDao;
import com.technicaltest.transaction.processing.system.models.documents.Transactions;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements  TransactionService {

    private final TransactionDao transactionDao;

    public TransactionServiceImpl(TransactionDao transactionDao){
        this.transactionDao = transactionDao;
    }

    @Override
    public Mono<Transactions> saveTransaction(Transactions transaction) {
        return transactionDao.save(transaction);
    }

    @Override
    public Flux<Transactions> getAllTransactions() {
        return transactionDao.findAll();
    }
}
