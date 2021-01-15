import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author lppppp
 * @create 2021-01-15 8:29
 */
public class MyLog {
    public static Logger logger = LoggerFactory.getLogger(MyLog.class);
    public static void main(String[] args) {
        logger.debug("my debug info");
        logger.warn("my warn info");
        logger.error("my error info");
        System.out.println("log");
    }

    //函数式风格创建对象，交给 spring 进行管理
    @Test
    public void testGenericApplicationContext() {
        //1 创建 GenericApplicationContext 对象
        GenericApplicationContext context =  new GenericApplicationContext();
        //2 调用 context 的方法对象注册
        context.refresh();
        //3 获取在 spring 注册的对象

        // 方式1
        // context.registerBean( User. class,() ->  new User());
        // User user = (User)context.getBean("User");

        //方式2
        context.registerBean( "user1",User. class,() ->  new User());
        User user = (User)context.getBean( "user1");
        System. out .println(user);
    }

}
