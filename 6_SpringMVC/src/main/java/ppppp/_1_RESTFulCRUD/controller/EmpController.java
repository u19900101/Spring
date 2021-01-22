package ppppp._1_RESTFulCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ppppp._1_RESTFulCRUD.dao.DepartmentDao;
import ppppp._1_RESTFulCRUD.dao.EmployeeDao;
import ppppp._1_RESTFulCRUD.entities.Department;
import ppppp._1_RESTFulCRUD.entities.Employee;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author lppppp
 * @create 2021-01-20 22:27
 */
@Controller
public class EmpController {

    public EmpController() {
        System.out.println("EmpController....");
    }

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
    public String add_page(Model model){
        model.addAttribute("employee", new Employee(1, "laName", "123.com", 0, new Date(120, 0, 21),new Department(5, "HOUSE")));
        return "addEmp";
    }

    //CRUD
    @RequestMapping(value = "/emp",method = {RequestMethod.POST,RequestMethod.PUT})
    public String add_update(@Valid Employee employee, BindingResult bindingResult,Model model){
        boolean errors = bindingResult.hasErrors();

        HashMap<String, Object> map = new HashMap<>();
        if(errors){
            // 为原生表单回显数据
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                String field = error.getField();
                String defaultMessage = error.getDefaultMessage();
                map.put(field, defaultMessage);
            }
            model.addAttribute("error_info",map);

            return "addEmp";
        }else {
            employeeDao.save(employee);
            return "redirect:/list";
        }
    }

    @RequestMapping(value = "/emp/{id}",method = {RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/emp/{id}",method = {RequestMethod.GET})
    public String before_update(Model model, @PathVariable Integer id){
        model.addAttribute("employee", employeeDao.get(id));
        // 交由 @ModelAttribute 处理
        // Collection<Department> departments = departmentDao.getDepartments();
        // model.addAttribute("departments", departments);
        return "editEmp";
    }

    // 每次运行之前都把 部门的信息放进去
    @ModelAttribute
    public void setDepartmentInfo(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
    }

}
