package bean;

import bean._1_base.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lppppp
 * @create 2021-01-13 10:19
 */
public class AutoWire {
    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7_autowire.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
