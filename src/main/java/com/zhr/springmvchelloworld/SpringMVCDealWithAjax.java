package com.zhr.springmvchelloworld;

import com.zhr.springmvchelloworld.dao.employeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@RestController
public class SpringMVCDealWithAjax {

    /**
     * {@code @Restcontroller注解是springMVC提供的一个复合注解，标识在控制器类上，就相当于为类添加了@Controller注解，并且为其中的}
     * 每一个方法添加了@ResponseBody注解
     *
     */
    @Autowired
    private employeeDao employeeDao;

    @RequestMapping("/test/requestbody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody: " + requestBody);
        return "success";
    }


    //使用map集合接受接送数据
    @RequestMapping("/test/json/request")
    public void testJson(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().println("hello,json");
    }
    // 使用实体类接受json数据
    @RequestMapping("/test/json")
    public void testJson1(@RequestBody User user,HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().println(user);
    }
    // @ResponseBody用于标识一个控制器方法，可以将方法的返回值直接作为响应报文的响应体响应到浏览器

    // 下列方式是返回到一个页面
    @RequestMapping("test/responsebody")
    public String testResponseBody() {
        return "success";
    }

    // 下列方式可以直接把success打印到屏幕上
    @RequestMapping("/test/resonsebody1")
    @ResponseBody
    public String testResponse1() {
        return "success";
    }

    // 将对象转化为json数据响应到浏览器上面
    @RequestMapping("/test/get/json")
    @ResponseBody
    public Collection<Employee> printJson() {
        return employeeDao.getAll();
    }
    // 响应map集合数据
    @RequestMapping("/test/json/map")
    @ResponseBody
    public Map<Integer, Employee> testJsonMap() {
        return employeeDao.getMap();
    }
    // 响应实体类对象
    @RequestMapping("/test/user")
    @ResponseBody
    public User getUser() {
        User nan = new User("1", "nan", 10, "12346");
        return nan;
    }

    // 使用ResponseEntity实现文件下载
    @RequestMapping("/test/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("img");
        realPath = realPath + File.separator + "头像.jpg";
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        MultiValueMap<String ,String > httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition","attachment;filename=头像.jpg");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,httpHeaders,statusCode);
        fileInputStream.close();
        return responseEntity;
    }
}
