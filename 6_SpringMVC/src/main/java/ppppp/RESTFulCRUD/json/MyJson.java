package ppppp.RESTFulCRUD.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ppppp.RESTFulCRUD.dao.EmployeeDao;
import ppppp.RESTFulCRUD.entities.Employee;

import java.util.Collection;

/**
 * @author lppppp
 * @create 2021-01-21 16:42
 */
//  @ResponseBody 的使用  直接将返回的对象转化为json格式
@Controller
public class MyJson {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/getAll")
    @ResponseBody
    public Collection<Employee> getAll(){
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }
}
