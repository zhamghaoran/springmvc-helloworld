package com.zhr.springmvchelloworld.controller;

import com.zhr.springmvchelloworld.Employee;
import com.zhr.springmvchelloworld.dao.employeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private employeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        Collection<Employee> allEmployee = employeeDao.getAll();
        // 将所有的员工信息在请求域共享
        model.addAttribute("allemployee",allEmployee);
        // 跳转到列表页面
        return "employee_list";
    }


}
