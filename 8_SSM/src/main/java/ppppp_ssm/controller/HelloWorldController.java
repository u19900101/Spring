package ppppp_ssm.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ppppp_ssm.dao.EmployeeMapper;
import ppppp_ssm.generate_bean.EmployeeExample;
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
    @Autowired
    private EmployeeMapper employeeMapper;

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

    @RequestMapping("/getEmpById")
    public String getEmpById(Model model){
        ppppp_ssm.generate_bean.Employee employee = employeeService.getEmpById(5);

        model.addAttribute("msg", employee);
        System.out.println(employee);
        return "forward:/success.jsp";
    }

    @RequestMapping("/page")
    public String page(@RequestParam(value = "pn",defaultValue = "1") Integer pageNum, Model model) {

        PageHelper.startPage(pageNum, 10);

        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        //紧跟着的第一条查询语句才有用  后面的无分页功能
        List<ppppp_ssm.generate_bean.Employee> emps = employeeMapper.selectByExample(employeeExample);
        //传入要连续显示多少页
        PageInfo<ppppp_ssm.generate_bean.Employee> info = new PageInfo<>(emps, 5);
        for (ppppp_ssm.generate_bean.Employee employee : emps) {
            System.out.println(employee);
        }

        System.out.println("当前页码：" + info.getPageNum());//  5
        System.out.println("总记录数：" + info.getTotal());// 1010
        System.out.println("每页的记录数：" + info.getPageSize());// 1
        System.out.println("总页码：" + info.getPages());// 1010
        System.out.println("是否第一页：" + info.isIsFirstPage()); //false
        System.out.println("连续显示的页码："); //3 4 5 6 7

        int[] nums = info.getNavigatepageNums();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        model.addAttribute("info", info);
        System.out.println(info);
        return "forward:/page.jsp";
    }
}
