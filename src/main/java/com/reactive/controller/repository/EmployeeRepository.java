package com.reactive.controller.repository;

import com.reactive.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee,String> {

    Mono<Employee> findById(String id);
    Flux<Employee> findAll();

}
