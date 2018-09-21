package fan.spring.prove.bootadmin.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by fanlingjie on 2018/9/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesServiceTest {
    @Autowired
    private PropertiesService propertiesService;


    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(propertiesService.getName(), "lj");
        Assert.assertEquals(propertiesService.getFlag(), "n");
        System.out.println("----------end-------------------" + propertiesService.getName());
    }

}