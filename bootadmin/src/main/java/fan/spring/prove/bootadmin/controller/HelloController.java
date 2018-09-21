package fan.spring.prove.bootadmin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanlingjie on 2018/9/4.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello FLJ";
    }
}
