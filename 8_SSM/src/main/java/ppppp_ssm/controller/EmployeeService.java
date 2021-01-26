package ppppp_ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppppp_ssm.dao.EmployeeDao;
import ppppp_ssm.pojo.Employee;

import java.util.List;

/**
 * @author lppppp
 * @create 2021-01-25 16:58
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    // @Autowired
    // private SqlSession sqlSession;

    public List<Employee> getEmps(){
        //EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeDao.getEmps();
    }
}
