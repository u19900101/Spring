package bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lppppp
 * @create 2021-01-12 22:07
 */
public class Emp {
    private String id;
    private Person person;

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", person=" + person +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3_inner.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
