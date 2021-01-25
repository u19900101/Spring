package p06_cache;

import dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lppppp
 * @create 2021-01-22 23:07
 */
// 二级缓存
public class cache_second_Level {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p06_cache/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    // 实现步骤：
    // 1.配置开启缓存
    // 2.在查询的map.xml上加上<cache></cache>
    // 3.一个session关闭或者提交后 才能将查询放入二级缓存
    @Test
    public void T_cache_newSession() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        SqlSession sqlSession2 = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee emp = employeeDao.getEmpById(1);
            System.out.println(emp);
            // 关闭之后才能用
            sqlSession.close();
            sqlSession2 = sqlSessionFactory.openSession();
            EmployeeDao employeeDao2 = sqlSession2.getMapper(EmployeeDao.class);

            Employee emp2 = employeeDao2.getEmpById(1);
            System.out.println(emp2);
            System.out.println(emp == emp2); // false

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession2.close();
        }
    }

    // 2.二级缓存与一级缓存之间的关系
    // 总是先查询二级缓存后再查询一级缓存
    @Test
    public void T_cache_relation() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        SqlSession sqlSession2 = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee emp = employeeDao.getEmpById(1);
            System.out.println(emp);
            // 关闭之后才能用
            sqlSession.close();
            sqlSession2 = sqlSessionFactory.openSession();
            EmployeeDao employeeDao2 = sqlSession2.getMapper(EmployeeDao.class);

            Employee emp2 = employeeDao2.getEmpById(1);
            System.out.println(emp2);
            System.out.println(emp == emp2); // false

            System.out.println("开始查询2号员工....");
            Employee emp_1 = employeeDao2.getEmpById(2);
            System.out.println(emp_1);
            System.out.println();
            Employee emp_2 = employeeDao2.getEmpById(2);
            System.out.println(emp_2);
            System.out.println();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession2.close();
        }
    }

}
