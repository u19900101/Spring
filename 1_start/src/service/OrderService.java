package service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author lppppp
 * @create 2021-01-13 14:26
 */
// @Component(value = "orderService")
// @Component("orderService")
/* 默认为类名首字母小写 */
@Component
public class OrderService {
    public void add(){
        System.out.println("come into OrderService add ....");
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean9_annotation.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.add();
    }

}

