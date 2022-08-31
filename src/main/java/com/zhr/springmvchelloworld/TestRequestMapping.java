package com.zhr.springmvchelloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * 5.@RequestMapping注解的header属性
 * 作用：通过当前请求的请求头信息来匹配请求，即浏览器发送的请求头信息要满足headers属性的设置
 * 若浏览器发送的请求路径和@RequestMapping注解的val属性匹配，但是请求头信息不匹配
 * 此时页面报错404
 * 6.@SpringMVC支持ant风格的路径
 * 在@RequestMapping注解的val属性中设置一些特殊字符
 * ？：任意的单个字符（不包括？）
 * *：任意个数的任意字符（不包括？和/）
 * **：任意的任意层数目录，注意使用方式只能把**写在双斜线中，前后不能有任何的其他字符
 * 7.@RequestMapping使用路径中的占位符
 * 传统的方式：/deleteuser?id=1
 * rest：/user/delete/1
 * 需要在@RequestMapping注解的val属性中所设置的路径中，是使用{xxx}的方式表示路径中的数据
 * 在通过@PathVarible注解，将占位符所标识的值与控制器方法的形参进行绑定
*/

@Controller
//@RequestMapping({"/test","/qaq"})
public class TestRequestMapping {
    //此时控制器方法所匹配的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/qaq"},
            method = {RequestMethod.POST,RequestMethod.GET}
            //params = {"username","!password","age=20"},
            //headers = {"referer"}
    )
    public String hello() {
        return "success";
    }
    @RequestMapping("/**/test/ant")
    public String testAnt() {
        return "success";
    }
    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable Integer id,@PathVariable String username) {
        System.out.println("id :" + id);
        System.out.println("username :" + username);
        return "success";
    }
}
