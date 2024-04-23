package com.ohgiraffers.employeetoy.employee.controller;


import com.ohgiraffers.employeetoy.employee.model.service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ohgiraffers.employeetoy.employee.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.Map;
import java.util.Objects;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }


    @GetMapping("list")
    public String findEverybody(Model model) {
        List<EmployeeDTO> employeeList = employeeService.findEmployee();
        System.out.println("employeeList = " + employeeList);
        model.addAttribute("employeeList", employeeList);

        return "employee/list";
    }

    @GetMapping("condition")
    public void sibasiba() {
    }

    @PostMapping("condition")
    public String sibal(Model model, @RequestParam String sabon) {
        System.out.println("sabon = " + sabon);
        EmployeeDTO employeeDTO1 = employeeService.sibal(sabon);
        model.addAttribute("one", employeeDTO1);

        return "employee/result";

    }

    @GetMapping("insert")
    public void update() {
    }

    @PostMapping("insert")
    public String updateEmployee(@RequestParam String empId, HttpSession httpSession) {
        System.out.println("empId = " + empId);
        String empid = employeeService.check(empId);
//        String empid2 = check.getEmpId();
//        String empid2 = check.getEmpId();
//        System.out.println("empid2 = " + empid2);
        System.out.println("check = " + empid);
        if(empid == null){
        httpSession.setAttribute("check", empId);
        return "redirect:/employee/insert2";
        }  else {
            return "/";
        }

    }

    @GetMapping("insert2")
    public void inset3(Model model, HttpSession httpSession) {
        String empId = (String) httpSession.getAttribute("check");
        System.out.println("empId12321 = " + empId);
        model.addAttribute("empId",empId);
    }


    @PostMapping("insert2")
    public String insert1(@ModelAttribute EmployeeDTO employeeDTO,
                          HttpSession httpSession, Model model) {



        employeeService.insertEmployee(employeeDTO);

        return "redirect:/employee/insert2";
    }


    @ExceptionHandler(Exception.class)
    public String userException() {

        return "error/nullPointer";
    }

    @GetMapping("delete")
    public void delete() {
    }

    @PostMapping("delete")
    public String deleteMenuByCode(@RequestParam("code") int code, RedirectAttributes rttr) {
        employeeService.deleteEmployeeBycode(code);
        rttr.addFlashAttribute("successMessage", "삭제 성공했습니다!!!!");

        return "redirect:/";

    }

    @GetMapping("update")
    public void UpdateEmployee() {
    }

    @PostMapping("update")
    public String updateEmployee(@ModelAttribute EmployeeDTO updateEmployee, RedirectAttributes rttr) {

        System.out.println("updateEmployee = " + updateEmployee);
        employeeService.updateEmployee(updateEmployee);

        rttr.addFlashAttribute("message", "Employee Updated");

        return "redirect:/";

    }

}
