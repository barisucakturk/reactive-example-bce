package com.reactive.controller.service;

import com.reactive.controller.repository.EmployeeRepository;
import com.reactive.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired(required = false)
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Mono<Employee> getEmployee(String id){
        return employeeRepository.findById(id);
    }

    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
