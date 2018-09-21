package fan.spring.prove.bootadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//SpringBootApplication是几个注解的集合，默认扫描当前包和子包,可以手动指定
@SpringBootApplication
@ComponentScan(basePackages = {"fan.spring.prove"})
public class BootadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootadminApplication.class, args);
	}
}
