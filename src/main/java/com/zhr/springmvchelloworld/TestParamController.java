package com.zhr.springmvchelloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.net.HttpCookie;

@Controller
public class TestParamController {
    /**
     * 在控制器方法的形参位置，设置和请求参数同名的形参，当向浏览器发送请求的时候，在匹配到请求映射时，在DispatcherServlet
     * 中就会将请求参数赋值给相应的形参
     */
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(String username,String password) {
        System.out.println(username + "  " + password);
        return "success";
    }


}
