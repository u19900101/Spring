package ppppp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/h2",method = RequestMethod.POST,params = {"username"})
    public String Hello2(){
        System.out.println("h2");
        return "success";
    }
    // param  映射请求参数  限定url
    @RequestMapping(value = "/h3",params = {"username"})
    public String Hello3(){
        System.out.println("h3");
        return "success";
    }
    // ant
    @RequestMapping("/h5")
    public String H5(){
        System.out.println("h5");
        return "success";
    }

    // ?  ：匹配文件名中的一个字符
    // *  : 匹配文件名中的任意字符或者一层路径
    // ** : 匹配多层路径
   /* @RequestMapping(value = "/h?")
    public String Hx(){
        System.out.println("h?.....");
        return "success";
    }*/

    // 只能占一层路径
   /* @RequestMapping(value = "/h?/{id}")
    public String HpathVariable(@PathVariable("id")String id){
        System.out.println("h?.....");
        System.out.println(id);
        return "success";
    }*/


    @RequestMapping(value = "/hk")
    public String Hparam(@RequestParam(value = "user",required = false,defaultValue ="MMM")String user){
        System.out.println("hk");
        System.out.println(user);
        return "success";
    }
}
