package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.annot.HelloBean;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_hellobean.xml")
class HelloSpringTest {
	
	@Autowired
	@Qualifier("helloC")
	Hello hello;

	@Resource(name="helloBean")
	HelloBean bean;
	
	@Test
	void helloBean() {
		assertEquals("Hello 어노테이션", bean.sayHello());
	}
	
	@Test @Disabled
	void hello() {
		assertEquals("Hello 생성자", hello.sayHello());
		hello.print();
	}
	
	

}
