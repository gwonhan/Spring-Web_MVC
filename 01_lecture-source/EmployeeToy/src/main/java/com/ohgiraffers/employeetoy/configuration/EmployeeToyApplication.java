package com.ohgiraffers.employeetoy.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan(basePackages = "com.ohgiraffers.employeetoy", annotationClass = Mapper.class)
public class EmployeeToyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeToyApplication.class, args);
    }

}
