package ppppp_ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppppp_ssm.dao.EmployeeDao;
import ppppp_ssm.dao.EmployeeMapper;
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

    @Autowired
    private EmployeeMapper employeeMapper;
    // @Autowired
    // private SqlSession sqlSession;

    public List<Employee> getEmps(){
        //EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeDao.getEmps();
    }

    public ppppp_ssm.generate_bean.Employee getEmpById(int i) {
        return employeeMapper.selectByPrimaryKey(i);
    }
}
