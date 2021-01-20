package ppppp.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lppppp
 * @create 2021-01-19 16:09
 */
@Controller
public class RestDemo {

  /*  @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String add(){
        System.out.println("add book");
        return "success";
    }*/
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String get(@PathVariable("bid")Integer bid){
        System.out.println("GET book"+bid);
        return "success";
    }


    @RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("bid")Integer bid){
        System.out.println("DELETE book"+bid);
        return "success";
    }
    // @ResponseBody
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
    public String update(@PathVariable("bid")Integer bid){
        System.out.println("PUT book"+bid);
        return "success";
    }
}
