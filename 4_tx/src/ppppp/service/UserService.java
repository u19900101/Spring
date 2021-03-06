package ppppp.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ppppp.config.TxConfig;
import ppppp.dao.UserDao;

/**
 * @author lppppp
 * @create 2021-01-14 19:31
 */
@Service
@Transactional
// @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {
    @Autowired
    private UserDao userDao;

    public void doBussiness(){
        userDao.inMoney(100,1);
        int i=10/0;
        userDao.outMoney(100,2);
    }

    @Test
    public void T_annotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.doBussiness();
    }

    @Test
    public void T_xml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_base_xml.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.doBussiness();
    }

    @Test
    public void T_allconfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.doBussiness();
    }
}
