package service;

import dao.OrderDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lppppp
 * @create 2021-01-13 14:26
 */
// @Component(value = "orderService")
// @Component("orderService")
/* 默认为类名首字母小写 */
@Service   //相当于  <bean id="orderService" class="service.OrderService">
public class OrderService {
    // 加入属性注解
    // @Autowired  // 根据类型进行注入
    // @Qualifier(value = "orderDaoImpl2") // 当有多个实现类时 则按照名称进行注入
    // @Resource  // 不带参数  按类型注入
    @Resource(name = "orderDaoImpl2") // 带参数按名称注入
    private OrderDao orderDao;
    public void add(){
        System.out.println("come into OrderService add ....");
        orderDao.addOrder();
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean9_annotation.xml");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.add();
    }

}

