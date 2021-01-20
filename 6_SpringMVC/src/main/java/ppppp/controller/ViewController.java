package ppppp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lppppp
 * @create 2021-01-20 15:35
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    //第1种跳转方法
    @RequestMapping("/h1")
    public String h1(){
        System.out.println("h1");
        return "../../success";
    }

    // 2和3 都不会进行拼串处理

    //第2种跳转方法 转发 webapp下的绝对路径
    @RequestMapping("/h2")
    public String h2(){
        System.out.println("h2");
        return "forward:/success.jsp";
    }

    //第3种跳转方法  直接重定向
    @RequestMapping("/h3")
    public String h3(){
        System.out.println("h3");
        return "redirect:/success.jsp";
    }
}
