package ppppp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lppppp
 * @create 2021-01-19 10:47
 */
@RequestMapping("/HelloServlet")
@Controller
public class HelloWorldController {
    // @RequestMapping("hello")  // 写不写 / 都可以
    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("hello");
        return "success";
    }
}
