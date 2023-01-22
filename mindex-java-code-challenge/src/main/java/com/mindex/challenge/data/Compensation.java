package com.mindex.challenge.data;


import java.time.LocalDate;
import java.util.Date;

public class Compensation {

    private Employee employee;
    private float salary;
    private LocalDate effectiveDate;

    public Compensation(){

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
