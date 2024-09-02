package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class HelloBeanTest {

	ApplicationContext context = null;
	
	@BeforeEach
	void init() {
		//1.Container Object 생성
		context = new GenericXmlApplicationContext("claspath:spring_hellobean.xml");
		
	}
	
	@Test
	void helloBean() {
		//2. Container생성한 Spring Bean 요청
		context.getBean("hello");
	}
	
	

}
