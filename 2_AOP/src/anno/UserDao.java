package anno;

import org.springframework.stereotype.Component;

/**
 * @author lppppp
 * @create 2021-01-13 22:54
 */
@Component
public class UserDao {
    public int add(int i,int j){
        // int i= 10/0;
        System.out.println("addMethod execute....");
        return i+j;
    }
}
