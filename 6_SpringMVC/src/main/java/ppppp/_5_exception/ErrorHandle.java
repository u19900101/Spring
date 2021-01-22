package ppppp._5_exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lppppp
 * @create 2021-01-22 10:49
 */
@Controller
public class ErrorHandle {
    @RequestMapping("/error/e1")
    public String  e1(){
        int i = 10/0;
        return "success";
    }

  /*  @ExceptionHandler(ArithmeticException.class)
    public String  e_handler(){
        System.out.println("come into error....");
        return "forward:/error.jsp";
    }*/

    //升级版 带回异常信息
    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView e2_handler(Exception e){
        System.out.println("come into error Advance....");
        ModelAndView view = new ModelAndView("forward:/error.jsp");
        view.addObject("msg",e);
        return view;
    }





}
