package fan.spring.prove.bootadmin.controller;

import fan.spring.prove.bootservice.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanlingjie on 2018/9/5.
 */
@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private StandService standService;


    @RequestMapping("/service")
    public String index() {
        Integer re = standService.addUser("flj");
        return String.valueOf(re);
    }

}
