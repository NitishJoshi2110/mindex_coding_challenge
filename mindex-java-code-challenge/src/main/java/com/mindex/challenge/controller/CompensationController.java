package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationDetails;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;


    @PostMapping("/employee/compensation/{id}")
    public Compensation create(@PathVariable String id,@RequestBody CompensationDetails compensationDetailsObject ){
        LOG.debug("Creating compensation for employee [{}]", id);

        return compensationService.create(id,compensationDetailsObject.getSalary(),compensationDetailsObject.getEffectiveDate());
    }

    @GetMapping("/employee/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Reading compensation for employee [{}]", id);

        return compensationService.read(id);
    }
}
