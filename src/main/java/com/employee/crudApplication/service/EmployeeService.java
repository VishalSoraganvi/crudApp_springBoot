package com.employee.crudApplication.service;

import com.employee.crudApplication.dto.EmployeeDto;
import com.employee.crudApplication.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId) throws EmployeeNotFoundException;
    List<EmployeeDto> getAllEmployees();
    void deleteEmployee(Long employeeId) throws EmployeeNotFoundException;
    EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException;
}
