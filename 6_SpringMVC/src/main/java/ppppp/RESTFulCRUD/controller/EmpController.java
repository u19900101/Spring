package ppppp.RESTFulCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ppppp.RESTFulCRUD.dao.DepartmentDao;
import ppppp.RESTFulCRUD.dao.EmployeeDao;
import ppppp.RESTFulCRUD.entities.Department;
import ppppp.RESTFulCRUD.entities.Employee;

import java.util.Collection;

/**
 * @author lppppp
 * @create 2021-01-20 22:27
 */
@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/list")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "list";
    }

    @RequestMapping("/toaddpage")
    public String addpage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("employee", new Employee(1, "laName", "123.com", 0, new Department(5, "HOUSE")));
        return "addEmp";
    }

    //CRUD
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/list";
    }

}
