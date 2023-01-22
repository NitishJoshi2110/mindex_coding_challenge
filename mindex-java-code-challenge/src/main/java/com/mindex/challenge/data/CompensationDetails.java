package com.mindex.challenge.data;

import java.time.LocalDate;

/**
 * CompensationDetails stores salary and effectiveDate obtained from CompensationController from RequestBody
 */

public class CompensationDetails {
    float salary;
    LocalDate effectiveDate;

    public CompensationDetails(){

    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
