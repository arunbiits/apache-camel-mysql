package arun.learning.camel.mysql.main;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import arun.learning.camel.mysql.domain.Employee;

public class CamelMain {

	public static void main(String[] args) {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			CamelContext camelContext = appContext.getBean("employeeContext",CamelContext.class);
			camelContext.start();
			ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
			
			Employee emp1 = new Employee("EMP01", "Arun Kumar");
			String resp = producerTemplate.requestBody("direct:insert", emp1, String.class);
			System.out.println(resp);
			
			Employee emp2 = new Employee("EMP02", "Sanjay");
			resp = producerTemplate.requestBody("direct:insert", emp2, String.class);
			System.out.println(resp);
			
			List<Employee> employees = producerTemplate.requestBody("direct:select", null, List.class);
			System.out.println(employees);
		} catch (CamelExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
