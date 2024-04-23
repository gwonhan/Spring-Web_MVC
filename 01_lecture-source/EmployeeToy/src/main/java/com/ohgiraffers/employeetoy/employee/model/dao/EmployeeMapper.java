package com.ohgiraffers.employeetoy.employee.model.dao;

import com.ohgiraffers.employeetoy.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;
import java.util.List;

@Mapper
public interface EmployeeMapper {

     List<EmployeeDTO> findEmployee();

    EmployeeDTO kimchman(String sabon);
    void insertEmployee(EmployeeDTO employeeDTO);

    void deleteNumByCode(int code);
    void updateEmployee(EmployeeDTO updateEmployee);

    String check(String gogobtn);
}
