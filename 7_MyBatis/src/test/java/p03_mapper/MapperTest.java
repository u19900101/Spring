package p03_mapper;

import ppppp.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ppppp.pojo.Employee;

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
public class MapperTest {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p03_mapper/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    // 查询获取 map
    // 多个参数的获取
    @Test
    public void T_all_map() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Map<Integer, Employee> allEmp = employeeDao.getAllEmpReturnMap();
            System.out.println(allEmp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    // 查询获取 单条map
    @Test
    public void T_map() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Map<String, Object> map = employeeDao.getEmpMapById(1);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    // 查询获取list
    // 多个参数的获取
    @Test
    public void T_all() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            List<Employee> allEmp = employeeDao.getAllEmp();
            allEmp.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
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
