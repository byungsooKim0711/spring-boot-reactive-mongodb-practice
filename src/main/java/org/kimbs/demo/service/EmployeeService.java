package org.kimbs.demo.service;

import org.kimbs.demo.document.Employee;
import org.kimbs.demo.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeService {

     private final EmployeeRepository employeeRepository;

     public EmployeeService(EmployeeRepository employeeRepository) {
         this.employeeRepository = employeeRepository;
     }

     public Flux<Employee> findAllEmployee() {
         return employeeRepository.findAllEmployee();
     }
}
