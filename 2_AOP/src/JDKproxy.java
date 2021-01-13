import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author lppppp
 * @create 2021-01-13 20:18
 */
public class JDKproxy {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        Class[] interfaces = {UserDao.class};
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKproxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = dao.add(1, 2);
        System.out.println(add);
        dao.update(10111);
    }
}
