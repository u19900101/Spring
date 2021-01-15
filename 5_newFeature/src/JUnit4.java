import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sound.midi.Soundbank;

/**
 * @author lppppp
 * @create 2021-01-15 8:56
 */
//整合JUnit4进行测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class JUnit4 {

    // 传统做法  通过路径加载配置文件
    @Test
    public void T_orgin(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }


    // 新的做法
    @Autowired
    User user;

    @Test
    public void T_new(){
        System.out.println(user);
    }
}
