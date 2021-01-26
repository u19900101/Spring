package p02_config;

import ppppp.dao.EmployeeDaoAnno;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ppppp.pojo.Employee;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lppppp
 * @create 2021-01-23 10:37
 */
public class Anno {
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
            EmployeeDaoAnno employeeDao = sqlSession.getMapper(EmployeeDaoAnno.class);
            Employee kk = employeeDao.getEmpById(1);
            System.out.println(kk);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
