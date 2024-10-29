package com.efundzz.SpringBootCaching.repository;

import com.efundzz.SpringBootCaching.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
