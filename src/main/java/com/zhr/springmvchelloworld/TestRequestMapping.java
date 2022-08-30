package com.zhr.springmvchelloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1. {@code @RequestMapping标识一个类，设置映射请求的路径的初始信息}
 *  {@code @RequestMapping标识一个方法，设置映射请求路径的具体信息}
 *  {@code @RequestMapping注解的val属性，}
 * 2.作用：用过请求的请求路径来匹配请求
 *  val属性是数组类型，即当前浏览器所发送请求的请求路径来匹配val 属性中的任何一个值
 *  则当前请求就会被注解所标识的的方法处理
 * 3. @RequestMapping的method属性
 * 作用：通过请求的请求方式匹配请求
 * method属性是RequestMethod类型的数组，即当前浏览器所发送的请求方式匹配method属性中的任何一种方法
 * 则当前请求就会被注解所标识的方法进行处理
 * 若浏览器所发送的请求的请求路径和@RequetsMethod注解的val属性匹配，但是请求方式不匹配，就会报错405.
 * 在@RequestMapping的基础上，结合请求方式的一些派生注解：
 * {@code @GetMapping，@PostMapping，@DeleteMapping，@PutMapping}
 * 4.@RequestMapping的params属性
 * 作用：通过请求的请求参数来匹配请求，即浏览器发送的请求参数必须满足params属性的设置
 * params可以设置四种表达式：
 * "param" ：表示所匹配的请求参数中必须携带param参数
 * "!param"：当前所匹配的请求参数中一定不能携带param参数
 * "param=value"：表示当前所匹配的请求参数中必须携带param且值必须等于val
 * "param!=value"：表示当前所匹配的请求参数中可以不携带param，若携带一定不等于val
 * 不匹配就会报400错误
 */

@Controller
//@RequestMapping({"/test","/qaq"})
public class TestRequestMapping {
    //此时控制器方法所匹配的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/qaq"},
            method = {RequestMethod.POST,RequestMethod.GET},
            params = {"username","!password","age=20"}
    )
    public String hello() {
        return "success";
    }
}
