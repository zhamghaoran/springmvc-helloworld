package com.zhr.springmvchelloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.processing.SupportedAnnotationTypes;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Map;

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
    public String getParamByServletAPI(String username, String password) {
        System.out.println(username + "  " + password);
        return "success";
    }

    /**
     * 通过pojo获取参数
     * <p>
     * 可以在控制器方法形参的位置设置一个实体类类型的形参，此时浏览器传输的请求参数的参数名和实体类中的属性名一致，
     * 那么请求参数就会为此属性赋值
     */
    @RequestMapping("/test/pojo")
    public String testPojo(User user) {
        System.out.println(user);
        return "success";
    }

    // 使用Request来共享数据
    @RequestMapping("/test/servletapi")
    public String testServletApi(HttpServletRequest request) {
        request.setAttribute("testScope", "Hello,ServletApi");
        return "success";
    }

    // 使用map来共享数据
    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
        map.put("testScope", "Hello,Map");
        return "success";
    }

    // 使用ModelAndView来共享数据
    @RequestMapping("/test/modelandview")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testScope", "hello,modelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    // 使用model来共享数据
    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testScope", "hello,Scope");
        return "success";
    }

    // 使用ModelMap来共享数据
    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap map) {
        map.addAttribute("testScope", "hello,modelMap");
        return "success";
    }

    /*
      Model、ModelMap、Map类型的参数其实本质上都是BindingAwareModelMap类型的
      public interface Model{}
      public class ModelMap extends LinkedHashMap<String, Object> {}
      public class ExtendedModelMap extends ModelMap implements Model {}
      public class BindingAwareModelMap extends ExtendedModelMap {}

     */

    // 向session共享数据
    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSession","hello,session");
        return "success";
    }

    // 向applicationContext共享数据

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplication","hello,application");
        return "success";
    }

}
