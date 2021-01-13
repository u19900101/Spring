package dao.impl;

import dao.OrderDao;
import org.springframework.stereotype.Repository;

/**
 * @author lppppp
 * @create 2021-01-13 15:13
 */
// @Repository(value = "OrderDaoImpl")
@Repository
public class OrderDaoImpl implements OrderDao {
    @Override
    public void addOrder() {
        System.out.println("OrderDaoImpl ....");
    }
}
