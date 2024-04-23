package com.ohgiraffers.employeetoy.configuration;

import com.ohgiraffers.employeetoy.employee.model.dao.EmployeeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
public class MainController {



    @GetMapping(value = {"/","main"})
    public String main() {
        return "main";
    }



}
