package ppppp.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ppppp.pojo.Address;
import ppppp.pojo.Book;

import java.util.Map;

/**
 * @author lppppp
 * @create 2021-01-19 21:35
 */
@Controller
@SessionAttributes(value = "msg")
public class BookController {


    // 获取原生的req
    @RequestMapping(value = "/origin")
    public void originMethod(HttpServletRequest req,HttpServletResponse res){
        String user = req.getParameter("user");
        System.out.println(user);
    }

    @RequestMapping(value = "/map")
    public String  mapMethod(Map<String,Object> map){
       map.put("msg", "LOVE");
       return "success";
    }
    @RequestMapping(value = "/model")
    public ModelAndView mapMethod(){
        ModelAndView success = new ModelAndView("success");
        success.addObject("msg","ModelAndView");
       return success;
    }


    @ModelAttribute("b1")
    public Book beforeadd(Map<String, Object>  map){
        System.out.println("before....add....");
        System.out.println(map);
        Book book = new Book("k1", "莫言", 198.02, 10, new Address("湖北", "武汉市", "江岸"), 20);
        return book;
    }
    // @RequestMapping(value = "/book",method = RequestMethod.POST)
    @RequestMapping(value = "/book")
    public String add(@ModelAttribute("b1")Book initBook2){
        System.out.println(initBook2);
        return "success";
    }

    @RequestMapping(value = "/bookt")
    public void bookt(@ModelAttribute("bookmmmm")Book book){
        System.out.println(book);
    }

}
