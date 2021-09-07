package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobPositionsService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPositions;

@RestController  // controller olduğunu belirttim
@RequestMapping("/api/jobpositions")  // istek alacağım domain
@CrossOrigin
public class JobPositionsController {
	
	private JobPositionsService jobPositionsService; // manager'i getirdik - business
	
	@Autowired  
	public JobPositionsController(JobPositionsService jobPositionsService) 
	{
		super();
		this.jobPositionsService = jobPositionsService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPositions>> getall()
	{
		
		return this.jobPositionsService.getAll();
		
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPositions jobPositions)  
	{
		return this.jobPositionsService.add(jobPositions);  
		// requestbody'deki bilgileri jobPositions şeklinde buradan parametreden alıyorum.
		// burdaki paketi de manager'deki metodu çağırarak oradan database'e save ediyorum.
		// değer döndüren bir metot olduğundan SuccessResult'a parametreli değer veriyorum.
		// ordaki işimi hallettikten sonra da bir şekilde değer döndürmem - bir yere bilgi göndermem gerek
	}
	
}
