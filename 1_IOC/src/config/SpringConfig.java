package config;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.OrderService;

/**
 * @author lppppp
 * @create 2021-01-13 15:49
 *
 * 纯注解 开发
 */
@Configuration //作为配置类，替代 xml 配置文件
@ComponentScan(basePackages = {"dao","service"})// 添加扫描路径
public class SpringConfig {
    @Test
    public void T(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.add();
    }
}
