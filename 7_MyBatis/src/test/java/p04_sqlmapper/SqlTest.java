package p04_sqlmapper;

import dao.DepartmentDao;
import dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Department;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lppppp
 * @create 2021-01-22 23:07
 */
public class SqlTest {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p04_sqlmapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    // 关联查询
    @Test
    public void T_() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee emp = employeeDao.getEmpById(4);
            System.out.println(emp.getDepartment().getId());
            // System.out.println(emp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    // 一对多查询
    @Test
    public void T_1_many() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
            Department emp = departmentDao.getEmpsById(4);
            List<Employee> employeeList = emp.getEmployeeList();
            employeeList.forEach(System.out::println);
            // System.out.println(employeeList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    // 分步查询
    @Test
    public void T_1_many_step() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            DepartmentDao departmentDao = sqlSession.getMapper(DepartmentDao.class);
            Department dep = departmentDao.getDepById(4);
            System.out.println(dep.getDepartmentName());
            // List<Employee> employeeList = emp.getEmployeeList();
            // employeeList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    // getEmpsByIdStep


}
