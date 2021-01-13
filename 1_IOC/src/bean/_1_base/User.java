package bean._1_base;

/**
 * @author lppppp
 * @create 2021-01-12 16:54
 */
public class User {
    public void setName(String name) {
        this.name = name;
        System.out.println("No2: set Method...user ");
    }

    private String name;

    public User() {
        System.out.println("No1: constructor...  come into ean._1_base.User ");
    }

    public void init(){
        System.out.println("No3: init ...come into bean._1_base.User ");
    }

    private void destory() {
        System.out.println("No5: destory ...come into bean._1_base.User ");
    }
}
