package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ReportingStructure report(String id) {
        LOG.debug("Reporting structure for [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);
        if (employee == null) {
            throw new RuntimeException("Employee doesn't exist: " + id);
        }

            int employeeCount = 0;
            Queue<Employee> queueEmployee = new ArrayDeque<>();
            HashSet<Employee> visited = new HashSet<>();

            queueEmployee.add(employee);
            visited.add(employee);


            while(!queueEmployee.isEmpty()){

                Employee reports = queueEmployee.remove();

                if(reports.getCurrentReport() != null){

                    for(Employee e : reports.getCurrentReport()){

                        if( !visited.contains(e)){
                            visited.add(e);
                            queueEmployee.add(e);
                            employeeCount++;

                            Employee employeeData = employeeRepository.findByEmployeeId(e.getEmployeeId());

                            e.setFirstName(employeeData.getFirstName());
                            e.setLastName(employeeData.getLastName());
                            e.setPosition(employeeData.getPosition());
                            e.setDepartment(employeeData.getDepartment());
                            e.setDirectReports(employeeData.getCurrentReport());

                        }
                    }
                }

            }

        ReportingStructure reportingStructure = new ReportingStructure(employee,employeeCount);

        return reportingStructure;
    }







}
