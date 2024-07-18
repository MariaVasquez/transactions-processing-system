package com.technicaltest.transaction.processing.system.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class TransactionDto {
    private int deviceNumber;
    private String userId;
    private String geoPosition;
    private int amount;
}
