package anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author lppppp
 * @create 2021-01-13 22:55
 */
@Component
@Aspect
public class UserDaoProxy {
    // @Before(value = "execution(* anno.UserDao.add(..))")
    @Before(value = "execution(* anno.*.*(..))")// 要一一对应，不可跨层
    public void before(){
        System.out.println("before .....");
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
    }
}
