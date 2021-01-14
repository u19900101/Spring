package ppppp.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author lppppp
 * @create 2021-01-14 19:58
 */
// @Component
// @Aspect
public class UserServiceProxy {

    @Before(value = "execution(* ppppp.service.UserService.doBussiness(..))")
    public void before(){
        System.out.println("UserServiceProxy before... 开启事务");
    }
    @Around(value = "execution(* ppppp.service.UserService.doBussiness(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before .....");
        proceedingJoinPoint.proceed();
        System.out.println("around after .....提交事务");
    }

    @AfterThrowing(value = "execution(* ppppp.service.UserService.doBussiness(..))")
    public void afterThrowing(){
        System.out.println("UserServiceProxy afterThrowing... 进行回滚");
    }
}
