package cs544.exercise10_2.client;

import cs544.exercise10_2.service.ICalculator;
import cs544.exercise10_2.service.IGreeting;
import cs544.exercise10_2.service.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		IGreeting remoteService = context.getBean("greetingHttpInvokerProxy", IGreeting.class);

		Person person = new Person("John", "Doe");
		String result = remoteService.getMessage(person);
		System.out.println("Receiving result: " + result);
		
		ICalculator calculatorService = context.getBean("calculatorHttpInvokerProxy", ICalculator.class);
		calculatorService.add(10);
		System.out.println("Receiving Calculator result: " + calculatorService.getResult());
		calculatorService.add(10);
		System.out.println("Receiving Calculator result: " + calculatorService.getResult());

	}
}