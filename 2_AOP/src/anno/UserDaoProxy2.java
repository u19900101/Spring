package anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lppppp
 * @create 2021-01-13 22:55
 */
@Component
@Aspect
@Order(2)
public class UserDaoProxy2 {
    //相同切入点的抽取
    @Pointcut(value = "execution(* anno.UserDao.add(..))")
    public void point(){}

    @Before(value = "point()")
    public void before(){
        System.out.println("UserDaoProxy2 before .....");
    }
}
