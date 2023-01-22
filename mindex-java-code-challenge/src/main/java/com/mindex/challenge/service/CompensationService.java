package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

import java.time.LocalDate;
import java.util.Date;

public interface CompensationService {
    Compensation create(String id, float salary, LocalDate effectiveDate);
    Compensation read(String id);
}
