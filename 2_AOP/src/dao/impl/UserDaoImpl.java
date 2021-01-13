package dao.impl;

import dao.UserDao;

/**
 * @author lppppp
 * @create 2021-01-13 20:03
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add ..." + a+" + "+b);
        return a+b;
    }

    @Override
    public void update(int a) {
        System.out.println("update ..." + a);
    }
}
