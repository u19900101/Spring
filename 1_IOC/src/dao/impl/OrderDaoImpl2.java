package dao.impl;

import dao.OrderDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author lppppp
 * @create 2021-01-13 15:13
 */
@Repository
public class OrderDaoImpl2 implements OrderDao {
    @Value("name....")
    private String name;
    @Override
    public void addOrder() {
        System.out.println("OrderDaoImpl2 ...."+name);
    }
}
