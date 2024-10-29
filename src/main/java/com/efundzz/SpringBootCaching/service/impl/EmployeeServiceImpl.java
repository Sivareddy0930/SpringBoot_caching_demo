package com.efundzz.SpringBootCaching.service.impl;

import com.efundzz.SpringBootCaching.dto.EmployeeDto;
import com.efundzz.SpringBootCaching.exception.EmployeeNotFoundException;
import com.efundzz.SpringBootCaching.model.Employee;
import com.efundzz.SpringBootCaching.repository.EmployeeRepository;
import com.efundzz.SpringBootCaching.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository repo;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employee) {
        Employee employeeObject = new Employee();
        employeeObject.setName(employee.getName());
        employeeObject.setAddress(employee.getAddress());
        Employee savedEmployee = repo.save(employeeObject);


        EmployeeDto savedEmployeeDto = new EmployeeDto();
        savedEmployeeDto.setId(savedEmployee.getId());
        savedEmployeeDto.setName(savedEmployee.getName());
        savedEmployeeDto.setAddress(savedEmployee.getAddress());
        return savedEmployeeDto;
    }

    @Override
    @Cacheable(value = "employee",key = "#id")
    public EmployeeDto getEmployeeById(Integer id) {

        Employee employee = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found wit id :- "+ id));

        EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setAddress(employee.getAddress());
            return employeeDto;

    }

    @Override
    public EmployeeDto updateEmployee(Integer id,EmployeeDto employeedto) {
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found wit id :- "+ id));

        employee.setName(employeedto.getName());
        employee.setAddress(employeedto.getAddress());
        Employee updatedEmployee = repo.save(employee);

        EmployeeDto updatedEmployeeDto = new EmployeeDto();
        updatedEmployeeDto.setId(updatedEmployee.getId());
        updatedEmployeeDto.setName(updatedEmployee.getName());
        updatedEmployeeDto.setAddress(updatedEmployee.getAddress());


        return updatedEmployeeDto;
    }

    @Override
    public void deleteEmployeeById(Integer id) {

        Employee employee = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found wit id :- "+ id));

        if(employee != null){
            repo.deleteById(id);
        }

    }
}
