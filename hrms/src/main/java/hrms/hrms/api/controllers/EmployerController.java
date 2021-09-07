package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;

@RestController  // controller olduğunu belirttim
@RequestMapping("/api/employer")  // istek alacağım domain
@CrossOrigin
public class EmployerController {
	
	private EmployerService employerService;
	
	@Autowired  //EmployerManager'i getirttim arka planda
	public EmployerController(EmployerService employerService) 
	{
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")  // bilgileri database'den-kendimden veriyorum
	public DataResult<List<Employer>> getall()
	{
		
		return this.employerService.getAll();
		
	}
	
	/*
	@PostMapping("/add")  // bilgileri requestbody'den alıyoruz
	public Result add(@RequestBody Employer employer)
	 {
		
		return this.employerService.add(employer);
		
	}
	
	*/
}
