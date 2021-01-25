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
public class cache_Test {
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p06_cache/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
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
            System.out.println(emp2);

            System.out.println(emp == emp2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
