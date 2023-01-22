package com.mindex.challenge.data;

import java.time.LocalDate;


public class CompensationDetails {
    LocalDate effectiveDate;

    float salary;

    public CompensationDetails(){

    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }


}
