package fan.spring.prove.bootadmin.controller;

import com.alibaba.fastjson.JSONObject;
import fan.spring.prove.bootdomain.MsgObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanlingjie on 2018/9/6.
 */
@RestController
public class ObejectController {

    @RequestMapping("/object")
    public String testObjedt(@RequestBody MsgObject msgObject){
        //这里不会 为null,会new一个在参数来承接值
        if(msgObject == null)
            return "none";
        System.out.println(JSONObject.toJSONString(msgObject));
        msgObject.setType(5);

        return JSONObject.toJSONString(msgObject);
    }


}
