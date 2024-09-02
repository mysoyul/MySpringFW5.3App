package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {
	@Value("${myName}") //("어노테이션")
	String name;
	
//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name="${printerName}")
	PrinterBean printer;
	
	@Value("#{'${arrayOfStrings}'.split(',')}")
	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!!");
	}

	public HelloBean(String name, PrinterBean printer) {
		System.out.println(this.getClass().getName() + " 오버로딩 생성자 호출됨!!");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

//	public void setName(String name) {
//		System.out.println(this.getClass().getName() + " setName() 호출됨 " + name);
//		this.name = name;
//	}
//
//	public void setPrinter(PrinterBean printer) {
//		System.out.println(this.getClass().getName() + " setPrinter() 호출됨 " + 
//				printer.getClass().getName());
//		this.printer = printer;
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
