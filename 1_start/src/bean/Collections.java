package bean;

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

    @Test
    public void T(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4_colls.xml");
        Collections collections = context.getBean("collections", Collections.class);
        List list = collections.list;
        Map<String, String> map = collections.map;
        String[] stu = collections.stu;
        Set set = collections.set;

        System.out.println(Arrays.asList(stu));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
    }
}
