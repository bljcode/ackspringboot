package fan.spring.prove.bootadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fanlingjie on 2018/9/4.
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/helloview")
    public String thymeleafHello(@RequestParam(defaultValue = "lj", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }


}
