package com.efundzz.SpringBootCaching.service;

import com.efundzz.SpringBootCaching.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employee);
    EmployeeDto getEmployeeById(Integer id);
    EmployeeDto updateEmployee(Integer id ,EmployeeDto employee);
    void deleteEmployeeById(Integer id);
}
