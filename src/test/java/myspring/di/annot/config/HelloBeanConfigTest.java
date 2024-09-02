package myspring.di.annot.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.annot.HelloBean;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class)
class HelloBeanConfigTest {
	@Autowired
	HelloBean helloBean;
	
	@Test
	void test() {
		assertEquals("Hello 어노테이션", helloBean.sayHello());
	}

}
