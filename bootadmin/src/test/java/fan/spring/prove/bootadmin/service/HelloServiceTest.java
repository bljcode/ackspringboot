package fan.spring.prove.bootadmin.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by fanlingjie on 2018/9/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
    @Autowired
    private HelloService helloService;
    @Test
    public void testAddUser() throws Exception {
        Assert.assertEquals(Integer.valueOf(1),helloService.addUser("lj"));
        System.out.println("-----------end-------------------");
    }
}