package myspring.di.annot.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"})
@PropertySource(value = "classpath:values.properties")
public class HelloBeanConfig {

	@Bean("nameList")
	public List<String> getMyNames() {
		return Arrays.asList("스프링프레임워크","스프링부트","쿠버네티스");
	}
}
