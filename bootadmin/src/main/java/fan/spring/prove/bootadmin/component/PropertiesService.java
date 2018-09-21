package fan.spring.prove.bootadmin.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by fanlingjie on 2018/9/4.
 */
@Component
public class PropertiesService {

    @Value("${fan.name}")
    private String name;
    @Value("${fan.flag}")
    private String flag;



    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getFlag() {
        return this.flag;
    }


    public void setFlag(String flag) {
        this.flag = flag;
    }
}
