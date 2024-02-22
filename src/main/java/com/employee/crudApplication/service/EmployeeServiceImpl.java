package com.employee.crudApplication.service;

import com.employee.crudApplication.dto.EmployeeDto;
import com.employee.crudApplication.entity.Employee;
import com.employee.crudApplication.exception.EmployeeNotFoundException;
import com.employee.crudApplication.mapper.EmployeeMapper;
import com.employee.crudApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isEmpty()){
            throw new EmployeeNotFoundException("Employee with id - " + employeeId + " not found.");
        }
        return EmployeeMapper.mapToEmployeeDto(employee.get());
    }

    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
         return employees.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
    }

    public void deleteEmployee(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFoundException {
        Optional<Employee> retrievedEmployee = employeeRepository.findById(employeeDto.getId());
        if(retrievedEmployee.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        Employee employee = retrievedEmployee.get();
        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        Employee createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createdEmployee);

    }
}
