package com.agh.controller;

import com.agh.model.Employees;
import com.agh.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping("employees")
    public ResponseEntity<List<Employees>> getAll() {
        return new ResponseEntity<>(employeesService.getAll(), HttpStatus.OK);
    }

    @GetMapping("employees/{employeeId}")
    public ResponseEntity<Employees> getById(@PathVariable Short employeeId) {
        return new ResponseEntity<>(employeesService.getById(employeeId), HttpStatus.OK);
    }

}
