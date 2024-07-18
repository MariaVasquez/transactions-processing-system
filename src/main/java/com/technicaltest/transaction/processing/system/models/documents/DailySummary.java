package com.technicaltest.transaction.processing.system.models.documents;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Document(collection = "dailysummary")
public class DailySummary {
    @Id
    private String transactionId;
    private LocalDateTime date;
    private double total_amount;
}
