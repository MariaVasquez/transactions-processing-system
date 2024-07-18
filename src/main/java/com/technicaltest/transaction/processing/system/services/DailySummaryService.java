package com.technicaltest.transaction.processing.system.services;

import com.technicaltest.transaction.processing.system.models.documents.DailySummary;
import reactor.core.publisher.Mono;

public interface DailySummaryService {
    Mono<DailySummary> saveDailySummary(DailySummary dailySummary);
}
