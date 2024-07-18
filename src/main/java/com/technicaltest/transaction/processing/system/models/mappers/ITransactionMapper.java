package com.technicaltest.transaction.processing.system.models.mappers;

import com.technicaltest.transaction.processing.system.controller.dto.TransactionDto;
import com.technicaltest.transaction.processing.system.models.documents.Transactions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITransactionMapper {

    @Mapping(target = "transactionId", ignore = true)
    @Mapping(target = "timestamp", ignore = true)
    Transactions toDto(TransactionDto transactionsDto);
}
