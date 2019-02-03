package com.reactive.boundary;

import com.reactive.controller.service.EmployeeService;
import com.reactive.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired(required = false)
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/id")
    public Mono<Employee> getEmployeeById(@PathVariable String id){
        return employeeService.getEmployee(id);
    }

    @GetMapping()
    public Flux<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }
}
