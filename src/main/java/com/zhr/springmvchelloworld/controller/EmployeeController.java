package com.zhr.springmvchelloworld.controller;

import com.zhr.springmvchelloworld.Employee;
import com.zhr.springmvchelloworld.dao.employeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @RequestMapping (value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        // 重定向到列表功能
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        // 将员工共享到请求域中
        model.addAttribute("employee",employee);
        return "employee_update";
    }
    @RequestMapping(value = "/employee" ,method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        // 修改员工信息
        employeeDao.save(employee);
        // 重定向到列表
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/delete/{id}",method = RequestMethod.GET)
    public String DeleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
