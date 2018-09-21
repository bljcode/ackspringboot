package fan.spring.prove.bootadmin.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//引入的静态方法
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by fanlingjie on 2018/9/4.
 * 类名上，Alt+Enter自动生成
 * AutoConfigureMockMvc mvc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void testIndex() throws Exception {
        //get content等是上面静态引入的方法
        this.mvc.perform(get("/hello")).andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
        System.out.println();
        System.out.println("-----------end-------------------");
    }
}