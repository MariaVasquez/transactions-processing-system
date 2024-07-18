package com.technicaltest.transaction.processing.system.models.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "transactions")
public class Transactions {
    @Id
    private String transactionId;
    private LocalDateTime timestamp;
    private int deviceNumber;
    private String userId;
    private String geoPosition;
    private int amount;

}
