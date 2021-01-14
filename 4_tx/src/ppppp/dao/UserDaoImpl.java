package ppppp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lppppp
 * @create 2021-01-14 19:34
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void inMoney(int amount, int accountId) {
        String sql = "update j_account set balance = balance+? where id = ?";
        int update = jdbcTemplate.update(sql, amount, accountId);
        System.out.println(update);
    }

    @Override
    public void outMoney(int amount, int accountId) {
        String sql = "update j_account set balance = balance-? where id = ?";
        int update = jdbcTemplate.update(sql, amount, accountId);
        System.out.println(update);
    }
}
