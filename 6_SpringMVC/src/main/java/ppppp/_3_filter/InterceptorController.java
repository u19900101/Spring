package ppppp._3_filter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lppppp
 * @create 2021-01-22 8:47
 */
@Controller
public class InterceptorController {
    @RequestMapping("/filter")
    public String f1(Model model){
        System.out.println("f1....");
        model.addAttribute("msg", "filter SUCCESS");
        return "forward:/success.jsp";
    }
}
