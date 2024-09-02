package myspring.di.annot.config;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;

/*
 * AnnotationConfigContextLoader 로더 클래스는 
 * AnnotationConfigApplicationContext 컨테이너 객체를 로딩 해주는 역할을 한다. 
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
		classes = HelloBeanConfig.class, 
		loader=AnnotationConfigContextLoader.class)
class HelloBeanConfigTest {
	@Autowired
	HelloBean helloBean;
	
	@Autowired
	List<String> nameList;
	
	@Test
	void test() {
		assertEquals("Hello 어노테이션", helloBean.sayHello());
		nameList.forEach(System.out::println);
	}

}
