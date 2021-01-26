package p02_config;

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

/**
 * @author lppppp
 * @create 2021-01-22 23:07
 */
public class ConfigTest {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p02_config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void T() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee kk = employeeDao.getEmpById(1);
            System.out.println(kk);
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
