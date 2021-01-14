package anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class UserDaoProxy {
    //相同切入点的抽取
    @Pointcut(value = "execution(* anno.UserDao.add(..))")
    public void point(){}

    // @Before(value = "execution(* anno.UserDao.add(..))")
    // @Before(value = "execution(* anno.*.*(..))")// 要一一对应，不可跨层
    @Before(value = "point()")
    public void before(){
        System.out.println("UserDaoProxy before .....");
    }

    // 最终通知 相当于finally，不管有无异常均会执行
    @After(value = "execution(* anno.*.*(..))")// 要一一对应，不可跨层
    public void after(){
        System.out.println("after .....");
    }
    @Around(value = "execution(* anno.*.*(..))")// 要一一对应，不可跨层
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before .....");
        proceedingJoinPoint.proceed();
        System.out.println("around after .....");
    }
    @AfterReturning(value = "execution(* anno.*.*(..))")// 要一一对应，不可跨层
    public void afterReturning(){
        System.out.println("AfterReturning .....");
    }

    // 有异常时会执行
    @AfterThrowing(value = "execution(* anno.*.*(..))")// 要一一对应，不可跨层
    public void afterThrowing(){
        System.out.println("AfterThrowing .....");
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
    }

    // 完全注解开发
    @Test
    public void T2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAOP.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
    }
}
