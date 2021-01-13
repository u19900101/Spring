package bean;

import bean._1_base.Person;
import bean._1_base.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;

/**
 * @author lppppp
 * @create 2021-01-13 8:52
 */
/* 演示生命周期 */
public class LifeBean {
    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6_life.xml");
        // 单例模式下，加载完配置文件之后就会按顺序执行以下三个方法，多例模式就会等到getBean时才开始调用
        //1.Constructor()
        //2.set
        //3.init(如果配置了的话)
        User user = context.getBean("user", User.class);
        System.out.println("No4: "+user);
        // Person person = context.getBean("person", Person.class);
        // 手动配置和手动调用 销毁   多例情况下无法销毁
        ((ClassPathXmlApplicationContext) context).close();
    }
}
