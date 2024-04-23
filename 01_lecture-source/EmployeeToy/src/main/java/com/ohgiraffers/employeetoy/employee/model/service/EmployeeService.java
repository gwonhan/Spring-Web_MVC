package com.ohgiraffers.employeetoy.employee.model.service;

import com.ohgiraffers.employeetoy.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.employeetoy.employee.model.dto.EmployeeDTO;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;


import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper){
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> findEmployee() {
        return employeeMapper.findEmployee();
    }

    public EmployeeDTO sibal(String sabon) {
        return employeeMapper.kimchman(sabon);
    }

    @Transactional
    public void insertEmployee(EmployeeDTO employeeDTO) {
        employeeMapper.insertEmployee(employeeDTO);
    }

    @Transactional
    public void deleteEmployeeBycode(int code) {
        employeeMapper.deleteNumByCode(code);
    }

    @Transactional
    public void updateEmployee(EmployeeDTO updateEmployee) {

        employeeMapper.updateEmployee(updateEmployee);

    }

    public String check(String gogobtn) {
        return employeeMapper.check(gogobtn);
    }
}
