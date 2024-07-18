package com.technicaltest.transaction.processing.system.dao;

import com.technicaltest.transaction.processing.system.models.documents.DailySummary;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DailySummaryDao extends ReactiveMongoRepository<DailySummary, String> {
}
