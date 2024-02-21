package com.employee.crudApplication.service;

import com.employee.crudApplication.dto.EmployeeDto;
import com.employee.crudApplication.entity.Employee;
import com.employee.crudApplication.mapper.EmployeeMapper;
import com.employee.crudApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee =EmployeeMapper.mapToEmployee(employeeDto);
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createdEmployee);
    }
}
