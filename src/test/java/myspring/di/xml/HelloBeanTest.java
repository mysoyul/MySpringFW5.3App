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
		//alt + shift + l(엘)
		//1.Container Object 생성
		context = new GenericXmlApplicationContext("classpath:spring_hellobean.xml");
	}
	
	@Test
	void helloBean() {
		//2. Container생성한 Spring Bean 요청
		Hello hello = (Hello)context.getBean("hello");
		Hello hello2 = context.getBean("hello", Hello.class);
		
		//Singleton object 여부 확인하기 위해서 주소비교
		System.out.println(hello == hello2);
		
		//scope="prototype"
		//assertNotSame(hello, hello2);
		
		//scope="singleton"
		assertSame(hello, hello2);
				
		assertEquals("Hello 스프링", hello.sayHello());
		
		hello.print();
		
		Printer printer = context.getBean("strPrinter", Printer.class);
		
		assertEquals("Hello 스프링", printer.toString());
	}
	
	

}
