package com.efundzz.SpringBootCaching.controller;

import com.efundzz.SpringBootCaching.dto.EmployeeDto;
import com.efundzz.SpringBootCaching.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee){
        EmployeeDto employeeDto = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getEmployee/{id}",produces = "application/json")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Integer id){
        EmployeeDto employeeById = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer id ,@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDtoResponse = employeeService.updateEmployee(id, employeeDto);
        return new ResponseEntity<>(employeeDtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
        return "Employee deleted successfully";
    }
}
