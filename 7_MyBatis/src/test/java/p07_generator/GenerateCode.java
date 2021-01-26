package p07_generator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import ppppp.generate_bean.Employee;
import ppppp.generate_bean.EmployeeExample;
import ppppp.generate_dao.EmployeeMapper;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author lppppp
 * @create 2021-01-26 9:34
 */
public class GenerateCode {
    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File(GenerateCode.class.getClassLoader().getResource("p07_gen/mbg.xml").getFile());
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "p07_gen/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    // 简单查询
    @Test
    public void T_geneMethod() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employeeList = employeeMapper.selectByPrimaryKey(5);
            System.out.println(employeeList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    // 多条件复杂查询
    @Test
    public void T_geneMethod_advance() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeExample employeeExample = new EmployeeExample();
            // 按照字段升序或者降序
            employeeExample.setOrderByClause("id DESC");
            // 创建一个查询准则
            EmployeeExample.Criteria criteria = employeeExample.createCriteria();
            criteria.andIdBetween(1, 15);
            criteria.andLastnameLike("%a%");

            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = employeeMapper.selectByExample(employeeExample);
            employees.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    // 批量插入
    @Test
    public void T_batch_insert() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> list = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                list.add(new Employee(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
            }
            int insertBatch = mapper.insertBatch(list);
            sqlSession.commit();
            System.out.println(insertBatch);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
