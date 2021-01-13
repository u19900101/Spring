package bean;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lppppp
 * @create 2021-01-13 10:48
 *
 */
// 通过配置文件获取连接池
public class DataSourceDemo {
    @Test
    public void T() throws SQLException {
        ApplicationContext context =new ClassPathXmlApplicationContext("bean8_jdbc.xml");
        DataSource dataSource = context.getBean("dataSource", DruidDataSource.class);

        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        QueryRunner runner = new QueryRunner();
        String sql = "select count(*) from t_user";
        Object query = runner.query(conn, sql, new ScalarHandler<>());
        System.out.println(query);
        System.out.println(dataSource);

    }
}
