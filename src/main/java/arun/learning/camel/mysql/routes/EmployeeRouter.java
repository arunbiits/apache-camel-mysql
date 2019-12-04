/**
 * 
 */
package arun.learning.camel.mysql.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author arun
 *
 */
public class EmployeeRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:insert")
			.log("Inserted New Employee")
			.beanRef("employeeMapper","getMap")
			.to("sqlComponent:{{sql.insertEmployee}}");
		
		from("direct:select").to("sqlComponent:{{sql.getAllEmployees}}")
			.beanRef("employeeMapper","readEmployees").log("${body}");
	}

}
