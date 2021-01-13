import dao.UserDao;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lppppp
 * @create 2021-01-13 20:08
 *
 * 在不改写原有的UserDao方法上，给该方法添加增强功能
 */
public class UserDaoProxy implements InvocationHandler {
    public Object obj;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before "+ method.getName());
        Object invoke = method.invoke(obj, args);
        System.out.println("after "+ method.getName());
        return invoke;
    }
}
