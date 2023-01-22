package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Compensation repository stores and retrieves compensation type details with an Employee type input parameter
 *
 */
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, Employee> {
    Compensation findCompensationByEmployee(Employee employee);
}
