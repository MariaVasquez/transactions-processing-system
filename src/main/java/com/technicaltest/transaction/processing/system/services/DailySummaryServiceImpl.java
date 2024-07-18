package com.technicaltest.transaction.processing.system.services;

import com.technicaltest.transaction.processing.system.dao.DailySummaryDao;
import com.technicaltest.transaction.processing.system.models.documents.DailySummary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DailySummaryServiceImpl implements DailySummaryService {

    private final DailySummaryDao dailySummaryDao;

    public DailySummaryServiceImpl(DailySummaryDao dailySummaryDao) {
        this.dailySummaryDao = dailySummaryDao;
    }

    @Override
    public Mono<DailySummary> saveDailySummary(DailySummary dailySummary) {
        return dailySummaryDao.save(dailySummary);
    }
}
