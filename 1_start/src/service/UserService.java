package service;

import dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lppppp
 * @create 2021-01-12 20:57
 */
public class UserService {
    // 把需要注入的当属性
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this. userDao = userDao;
    }
    public void add() {
        System. out .println( "service add...............");
        userDao.update();
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2_out.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
