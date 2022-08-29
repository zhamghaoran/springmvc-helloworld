package com.zhr.springmvchelloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * {@code @RequestMapping标识一个类，设置映射请求的路径的初始信息}
 * {@code @RequestMapping标识一个方法，设置映射请求路径的具体信息}
 */

@Controller
@RequestMapping("/test")
public class TestRequestMapping {
    //此时控制器方法所匹配的请求路径为/test/hello
    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }
}
