import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lppppp
 * @create 2021-01-12 16:55
 */
public class TestSpring5 {
    @Test
    public void T(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = (User) context.getBean("user");
        user.add();
    }
}
