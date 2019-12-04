/**
 * 
 */
package arun.learning.camel.mysql.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arun.learning.camel.mysql.domain.Employee;

/**
 * @author arun
 *
 */
public class EmployeeMapper {
	
	public Map<String, Object> getMap(Employee employee){
		Map<String, Object> answer = new HashMap<String, Object>();
		answer.put("EmpId", employee.getEmpId());
		answer.put("EmpName", employee.getEmpName());
		return answer;
	}
	
	public List<Employee> readEmployees(List<Map<String,String>> dataList){
		System.out.println(dataList);
		List<Employee> employees = new ArrayList<Employee>();
		for(Map<String, String> data:dataList) {
			Employee employee = new Employee();
			employee.setEmpId(data.get("EmpId"));
			employee.setEmpName(data.get("EmpName"));
			employees.add(employee);
		}
		return employees;
	}
}
