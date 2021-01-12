package bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lppppp
 * @create 2021-01-12 16:55
 */
public class TestSpring5 {
    @Test
    public void T(){
        /* 懒加载 */
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");
        /* 饿汉式加载 */
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user",User.class);
        user.init();
    }

    public <T>T beanFac(String className){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        T t = (T)context.getBean(className);
        return t;
    }

    @Test
    public void T2(){
        Person p = beanFac("person");
        p.init();

        User user = beanFac("user");
        user.init();
    }

    @Test
    public void T3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Object person = context.getBean("person");
        System.out.println(person);
    }
}
