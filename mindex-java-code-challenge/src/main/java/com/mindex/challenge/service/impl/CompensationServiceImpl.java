package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;


@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    public Compensation create(String id, float salary, LocalDate effectiveDate){
        LOG.debug("Compensation for employee [{}]", id);

        if (salary <= -1) {
            throw new RuntimeException("Error in salary: " + salary);
        }Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("EmployeeId does not exist: " + id);
        }


        Compensation c1 = compensationRepository.findCompensationByEmployee(employee);
        if(c1 != null ){
            throw new RuntimeException("Compensation is created earlier for employee having id : " + id);
        }

        c1 = new Compensation();
        c1.setEmployee(employee);
        c1.setEffectiveDate(effectiveDate);
        c1.setSalary(salary);
        compensationRepository.insert(c1);


        return c1;
    }


    public Compensation read(String id) {
        LOG.debug("Fetching compensation for [{}]", id);
        Employee e1 = employeeRepository.findByEmployeeId(id);
        if(e1 == null){
            throw new RuntimeException("EmployeeId does not exist: " + id);
        }

        Compensation c1 = compensationRepository.findCompensationByEmployee(e1);
        if (c1 == null) {
            throw new RuntimeException("Compensation does not exist for : " + id);
        }

        return c1;
    }

}
