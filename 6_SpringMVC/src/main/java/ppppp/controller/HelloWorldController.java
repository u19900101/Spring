package ppppp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lppppp
 * @create 2021-01-19 10:47
 */
// @RequestMapping("/HelloServlet")
@Controller
public class HelloWorldController {
    // @RequestMapping("hello")  // 写不写 / 都可以
    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("hello");
        return "success";
    }

    @RequestMapping(value = "/h2",method = RequestMethod.POST)
    public String Hello2(){
        System.out.println("hello");
        return "success";
    }
    // param
    @RequestMapping(value = "/h3",params = {"username"})
    public String Hello3(){
        System.out.println("hello");
        return "success";
    }
}
