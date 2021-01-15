
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lppppp
 * @create 2021-01-15 9:14
 */
//整合JUnit5进行测试
// @ExtendWith(SpringExtension.class)
// @ContextConfiguration("classpath:bean.xml")

//使用一个复合注解替代上面两个注解完成整合
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JUnit5 {
    // 新的做法
    @Autowired
    User user;

    @Test
    public void T_new(){
        System.out.println(user);
    }
}
