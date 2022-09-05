package com.zhr.springmvchelloworld.controller;

import com.zhr.springmvchelloworld.Employee;
import com.zhr.springmvchelloworld.dao.employeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
    @Autowired
    private employeeDao employeeDao;



}
