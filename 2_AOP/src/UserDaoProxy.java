import dao.UserDao;
import dao.impl.UserDaoImpl;
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
public class UserDaoProxy{
    public UserDao target;
    public UserDaoProxy(UserDao target) {
        this.target = target;
    }
    public UserDao getLoggingProxy(){

        //代理对象由哪一个类加载器进行加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，其中有哪些方法
        Class[] interfaces = {UserDao.class};
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法  "+ method.getName()+ " 开始执行！");
                Object invoke = method.invoke(target, args);
                System.out.println("方法  "+ method.getName()+ " 结束执行！");
                return invoke;
            }
        };
        UserDao proxy =  (UserDao) Proxy.newProxyInstance(loader, interfaces, handler);
        return proxy;
    }


    public static void main(String[] args) {
        UserDaoProxy userDaoProxy = new UserDaoProxy(new UserDaoImpl());
        UserDao loggingProxy = userDaoProxy.getLoggingProxy();
        int add = loggingProxy.add(1, 2);
        System.out.println(add);
        loggingProxy.update(2);
    }
}
