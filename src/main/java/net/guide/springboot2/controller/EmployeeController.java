package net.guide.springboot2.controller;


import net.guide.springboot2.exception.ResourceNotFoundException;
import net.guide.springboot2.model.Employee;
import net.guide.springboot2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/get")
    public List<Employee> getAllEmployee(){
            return  employeeRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id")String id)
    throws ResourceNotFoundException {
       Employee employee =  employeeRepository.findById(Long.parseLong(id))
                .orElseThrow(()->new ResourceNotFoundException("Employee is not found ::"+id));
                return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/createEmployee")
    public Employee createEomplyee(@Valid @RequestBody Employee employee){
        return  employeeRepository.save(employee);
    }



}
