package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.EmployeeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getall()
	{
		
		return this.employeeService.getAll();
		
	}
	
	
	/*@PostMapping("/add")
	public Result add(@RequestBody Employee employee)  
	{
		return this.employeeService.add(employee);  
		
	}
	*/
	
}
