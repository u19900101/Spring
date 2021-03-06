package bean._1_base;

/**
 * @author lppppp
 * @create 2021-01-12 19:19
 */
public class Person {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "bean._1_base.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("person set ...");
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
        System.out.println("come into person Constructor() ...");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void init(){
        System.out.println("come into bean._1_base.Person init ...");
    }
}
