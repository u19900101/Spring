package p01_HelloWorld;

import p01_HelloWorld.HelloWorldTest;
import dao.EmployeeDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import pojo.Employee;

import java.io.IOException;
import java.util.Date;

/**
 * @author lppppp
 * @create 2021-01-22 23:07
 */
public class _2_CRUDTest {
    @Test
    public void T() throws IOException {
        SqlSessionFactory sqlSessionFactory = HelloWorldTest.getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
            // int kk = employeeDao.addEmp(new Employee("kk", "123.kk@qq.com", 1, new Date()));
            int kk = employeeDao.updateEmp(new Employee(2,"kk", "123.kk@qq.com", 1, new Date()));
            // int kk = employeeDao.delEmp(2);
            System.out.println(kk);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //手动进行提交
            sqlSession.commit();
            sqlSession.close();
        }


    }
}
