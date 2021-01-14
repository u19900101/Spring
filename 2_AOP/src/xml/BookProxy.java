package xml;

import org.aspectj.lang.JoinPoint;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lppppp
 * @create 2021-01-14 9:48
 */
public class BookProxy {
    public void before(){
        System.out.println("BookProxy before ....");
    }

    public void after(){
        System.out.println("BookProxy after ....");
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_book.xml");
        Book book = context.getBean("book", Book.class);
        book.add();
    }
}
