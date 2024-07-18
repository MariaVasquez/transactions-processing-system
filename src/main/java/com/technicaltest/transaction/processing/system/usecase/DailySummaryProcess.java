package com.technicaltest.transaction.processing.system.usecase;

import com.technicaltest.transaction.processing.system.models.documents.DailySummary;
import com.technicaltest.transaction.processing.system.services.DailySummaryService;
import com.technicaltest.transaction.processing.system.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DailySummaryProcess {

    private static final Logger log = LoggerFactory.getLogger(DailySummaryProcess.class);

    private final TransactionService transactionService;
    private final DailySummaryService dailySummaryService;

    public DailySummaryProcess(TransactionService transactionService, DailySummaryService dailySummaryService) {
        this.transactionService = transactionService;
        this.dailySummaryService = dailySummaryService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void generateDailySummary() {
        log.info("Generating daily summary");
        LocalDateTime today = LocalDateTime.now();

        transactionService.getAllTransactions()
                .filter(transaction -> transaction.getTimestamp().toLocalDate().isEqual(today.toLocalDate()))
                .reduce(0.0, (sum, transaction) -> sum + transaction.getAmount())
                .flatMap(total -> {
                    DailySummary summary = DailySummary.builder()
                            .date(today)
                            .total_amount(total).build();
                    return dailySummaryService.saveDailySummary(summary);
                })
                .subscribe(transaction -> log.info("Insert daily summary: {}", transaction.getTotal_amount()));
    }
}
