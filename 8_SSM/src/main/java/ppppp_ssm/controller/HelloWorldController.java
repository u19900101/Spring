package ppppp_ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ppppp_ssm.pojo.Employee;
import java.io.Serializable;
import java.util.List;

/**
 * @author lppppp
 * @create 2021-01-19 10:47
 */
@Controller
public class HelloWorldController  implements Serializable {

    private static final long serialVersionUID = -5415910268862124882L;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/getEmps")
    public String getEmps(Model model){
        List<Employee> emps = employeeService.getEmps();
        emps.forEach(System.out::println);
        model.addAttribute("msg", emps);
        System.out.println("hello");
        return "forward:/success.jsp";
    }

    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("hello");
        return "forward:/success.jsp";
    }



}
