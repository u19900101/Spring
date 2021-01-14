package ppppp.dao;

/**
 * @author lppppp
 * @create 2021-01-14 19:33
 */
public interface UserDao {
    void inMoney(int amount, int accountId);

    void outMoney(int amount, int accountId);
}
