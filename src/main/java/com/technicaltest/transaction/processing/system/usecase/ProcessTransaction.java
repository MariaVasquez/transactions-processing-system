package com.technicaltest.transaction.processing.system.usecase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicaltest.transaction.processing.system.controller.dto.ResponseCode;
import com.technicaltest.transaction.processing.system.controller.dto.TransactionDto;
import com.technicaltest.transaction.processing.system.controller.dto.error.CustomException;
import com.technicaltest.transaction.processing.system.models.documents.Transactions;
import com.technicaltest.transaction.processing.system.models.mappers.ITransactionMapper;
import com.technicaltest.transaction.processing.system.services.TransactionService;
import com.technicaltest.transaction.processing.system.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Component
public class ProcessTransaction {

    private static final Logger log = LoggerFactory.getLogger(ProcessTransaction.class);

    @Autowired
    private ITransactionMapper iTransactionMapper;

    private final TransactionService transactionService;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ProcessTransaction(KafkaTemplate<String, String> kafkaTemplate, TransactionService transactionService) {
        this.kafkaTemplate = kafkaTemplate;
        this.transactionService = transactionService;
    }

    public void executeTransaction(TransactionDto transactionDto) {
        log.info("Executing transaction");
        try {
            kafkaTemplate.send(Constants.TOPIC,objectMapper.writeValueAsString(transactionDto));
            Transactions transactions = iTransactionMapper.toDto(transactionDto);
            Flux.just(transactions).flatMap(transaction->{
                transactions.setTimestamp(LocalDateTime.now());
                return transactionService.saveTransaction(transactions);
            }).subscribe(transaction -> log.info("Insert: {}", transaction.getTransactionId()) );

        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new CustomException(ResponseCode.LCC000, ResponseCode.LCC000.getHtmlMessage());
        }
    }
}
