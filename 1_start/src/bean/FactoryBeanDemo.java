package bean;

import bean._1_base.Person;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lppppp
 * @create 2021-01-13 8:09
 */
public class FactoryBeanDemo implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4_factory.xml");
        Person factoryBeanDemo = context.getBean("factoryBeanDemo", Person.class);
        System.out.println(factoryBeanDemo);
    }
}
