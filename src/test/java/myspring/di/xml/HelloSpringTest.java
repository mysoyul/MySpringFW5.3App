package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_hellobean.xml")
class HelloSpringTest {
	
	@Autowired
	@Qualifier("helloC")
	Hello hello;

	@Test
	void hello() {
		assertEquals("Hello 생성자", hello.sayHello());
		hello.print();
	}

}
