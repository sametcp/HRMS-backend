package hrms.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.EmployeeService;
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
	public ResponseEntity<?> getall()
	{
		return ResponseEntity.ok(this.employeeService.getAll());
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee)  
	{
		return ResponseEntity.ok(this.employeeService.add(employee));  
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Employee employee)
	{
		
		return ResponseEntity.ok(this.employeeService.update(employee));
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id)
	{
		
		return ResponseEntity.ok(this.employeeService.getById(id));
		
	}
	
}
