package fan.spring.prove.bootservice;

import org.springframework.stereotype.Service;

/**
 * Created by fanlingjie on 2018/9/4.
 */
@Service
public class StandService {

    public Integer addUser(String username){
        System.out.println("user user, username="+username);
        if(username == null){
            return 0;
        }
        return 1;
    }


    public static void main(String[] args){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

}