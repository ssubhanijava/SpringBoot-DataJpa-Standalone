package com.subbu.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subbu.model.Employee;

public interface EmployeeJpa extends JpaRepository<Employee, Integer> {

}
