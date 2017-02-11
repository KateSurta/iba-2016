package test.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.spring.aop.objects.SomeService;

public class Start {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/start/context.xml");
		SomeService service = (SomeService) context.getBean("someService");
		double val = service.getDoubleValue();
	}
}
