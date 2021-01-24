package p05_dynamic_sql;

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
import java.util.List;

/**
 * @author lppppp
 * @create 2021-01-22 23:07
 */
public class dynamic_sql_Test {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p05_dynamic_sql/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    // where if 模糊查询
    @Test
    public void T_() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee();
            employee.setId(5);
            employee.setLastName("%k%");
            List<Employee> emp = employeeDao.getEmpByIdDynamic(employee);
            emp.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

  // <!--2. foreach 标签 解决 id = [1,2,3]形式的查询 -->
    @Test
    public void T_getEmpByIdsDynamic() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Integer[] ids = {1,2,3,30};
            List<Employee> emp = employeeDao.getEmpByIdsDynamic(ids);
            emp.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


}
