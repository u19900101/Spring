package ppppp._5_exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lppppp
 * @create 2021-01-22 11:11
 */
// 全局异常的处理
@ControllerAdvice
public class ExceptionConfig {
    //升级版 带回异常信息
    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView e2_handler(Exception e){
        System.out.println("come into error all ------Advance....");
        ModelAndView view = new ModelAndView("forward:/error.jsp");
        view.addObject("msg",e);
        return view;
    }
}
