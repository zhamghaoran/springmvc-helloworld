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
     * <p>
     * 若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串
     * <p>
     * 数组或者字符串类型的形参接收此请求参数
     * <p>
     * 若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
     * <p>
     * 若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果
     */
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(String username,String password) {
        System.out.println(username + "  " + password);
        return "success";
    }

    /**
     *通过pojo获取参数
     * <p>
     * 可以在控制器方法形参的位置设置一个实体类类型的形参，此时浏览器传输的请求参数的参数名和实体类中的属性名一致，
     * 那么请求参数就会为此属性赋值
     */
    @RequestMapping("/test/pojo")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }


    @RequestMapping("/test/servletapi")
    public String testServletApi(HttpServletRequest request) {
        request.setAttribute("testScope","Hello,ServletApi");
        return "success";
    }

    @RequestMapping("/test/get")
    public String getServletApi(HttpServletRequest request) {
        Object testScope = request.getAttribute("testScope");
        System.out.println(testScope);
        return "success";

    }

}