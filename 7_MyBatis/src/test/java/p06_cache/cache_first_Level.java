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
import java.util.List;

/**
 * @author lppppp
 * @create 2021-01-22 23:07
 */
  /*
    *       1. 不同的SqlSession对应不同的一级缓存
            2. 同一个SqlSession但是查询条件不同
            3. 同一个SqlSession两次查询期间执行了任何一次**增删改**操作
            4. 同一个SqlSession两次查询期间手动清空了缓存
    * */
public class cache_first_Level {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p06_cache/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    // 不同的SqlSession对应不同的一级缓存
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

            sqlSession2 = sqlSessionFactory.openSession();
            EmployeeDao employeeDao2 = sqlSession2.getMapper(EmployeeDao.class);

            Employee emp2 = employeeDao2.getEmpById(1);
            System.out.println(emp2);
            System.out.println(emp == emp2); // false

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
            sqlSession2.close();
        }
    }
    // 1.缓存  默认开启了缓存  相同的查询语句 只执行 一次
    @Test
    public void T_cache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee emp = employeeDao.getEmpById(1);
            System.out.println(emp);
            Employee emp2 = employeeDao.getEmpById(1);
            System.out.println(emp);
            System.out.println(emp == emp2); // true

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    // 3.两次查询期间执行了任何一次**增删改**操作

    @Test
    public void T_cache2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            Employee emp = employeeDao.getEmpById(1);
            System.out.println(emp);

            Employee employee = new Employee();
            employee.setId(5);
            employee.setLastName("k");
            employeeDao.updateEmpDynamic(employee);
            Employee emp2 = employeeDao.getEmpById(1);
            System.out.println(emp2);

            System.out.println(emp == emp2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

   //4.同一个SqlSession两次查询期间手动清空了缓存
   @Test
   public void T_cache_clearCache() throws IOException {
       SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
       SqlSession sqlSession = null;
       try {
           sqlSession = sqlSessionFactory.openSession();
           EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);

           Employee emp = employeeDao.getEmpById(1);
           System.out.println(emp);

           sqlSession.clearCache();

           Employee emp2 = employeeDao.getEmpById(1);
           System.out.println(emp2);

           System.out.println(emp == emp2);

       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           sqlSession.close();
       }
   }
}
