package bean;

import bean._1_base.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lppppp
 * @create 2021-01-12 23:00
 */
public class Collections {
    private String []stu;
    private List list;
    private Map<String,String> map;
    private Set set;

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    private List<Person> personList;

    public void setStu(String[] stu) {
        this.stu = stu;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "stu=" + Arrays.toString(stu) +
                ",\n list=" + list +
                ",\n map=" + map +
                ",\n set=" + set +
                ", \n personList=" + personList +
                '}';
    }

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4_colls.xml");
        Collections collections = context.getBean("collections", Collections.class);
        System.out.println(collections);
    }
}
