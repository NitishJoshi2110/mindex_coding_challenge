package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;


    @Autowired
    private EmployeeService employeeService;

    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);

        Employee employee = employeeService.create(compensation.getEmployee());
        compensation.setEmployee(employee);
        compensationRepository.insert(compensation);

        return compensation;
    }

    @Override
    public Compensation read(String id) {
        LOG.debug("Reading compensation for employee with id [{}]", id);

        Employee employee = employeeService.getEmployeeDetails(id);
        Compensation compensation = getCompensation(employee);

        return compensation;
    }

    @Override
    public Compensation getCompensation(Employee employee) {
        Compensation compensation = compensationRepository.getEmployeeDetails(employee);
        if (compensation != null) {
            return compensation;
        }
        else{
        throw new RuntimeException("No compensation data for employeeId: " + employee.getEmployeeId());

        }
    }

}
