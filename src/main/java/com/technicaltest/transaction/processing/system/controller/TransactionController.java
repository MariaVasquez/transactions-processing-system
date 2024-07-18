package com.technicaltest.transaction.processing.system.controller;

import com.technicaltest.transaction.processing.system.controller.dto.GenericResponseDto;
import com.technicaltest.transaction.processing.system.controller.dto.ResponseCode;
import com.technicaltest.transaction.processing.system.controller.dto.TransactionDto;
import com.technicaltest.transaction.processing.system.usecase.ProcessTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final ProcessTransaction processTransaction;

    public TransactionController(ProcessTransaction processTransaction){
        this.processTransaction = processTransaction;
    }

    @PostMapping("/save-transaction")
    public Mono<GenericResponseDto<String>> saveTransaction(@RequestBody TransactionDto transactionDto) {
        log.info("Init process transaction");
        processTransaction.executeTransaction(transactionDto);
        return Mono.just(new GenericResponseDto<>(ResponseCode.LCC001,ResponseCode.LCC001.getHtmlMessage(), null));
    }

}
