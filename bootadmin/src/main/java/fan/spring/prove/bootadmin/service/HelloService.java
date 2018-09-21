package fan.spring.prove.bootadmin.service;

import org.springframework.stereotype.Service;

/**
 * Created by fanlingjie on 2018/9/4.
 * 放在这里的service因为在主类BootadminApplication的子包，不配置也可以被默认扫描到
 */
@Service
public class HelloService {

    public Integer addUser(String username){
        System.out.println("user user, username="+username);
        if(username == null){
            return 0;
        }
        return 1;
    }

}
