package p03_mapper;

import dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

/**
 * @author lppppp
 * @create 2021-01-22 23:07
 */
public class MapperTest {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p03_mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    // 多个参数的获取
    @Test
    public void T() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee kk = employeeDao.getEmpByIdAndName(11,"kk");
            HashMap <String,Object> map = new HashMap<>();
            map.put("id", 11);
            map.put("lastName", "kk");
            // 动态的修改表名
            // map.put("tableName", "t_employee");
            map.put("tableName", "t_employee_copy");
            Employee empByMap = employeeDao.getEmpByMap(map);
            System.out.println(empByMap);
            // System.out.println(kk);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    // 获取自增的key
    @Test
    public void T2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee("kk", "123.kk@qq.com", 1, new Date());
            int kk = employeeDao.addEmp(employee);
            System.out.println(kk);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
