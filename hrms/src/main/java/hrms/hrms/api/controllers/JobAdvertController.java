package hrms.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDto;
import hrms.hrms.entities.dtos.LinkForCVDto;

@RestController
@RequestMapping("/api/jobadvert")
@CrossOrigin
public class JobAdvertController {
	
	private JobAdvertService jobAdvertService; // business

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) 
	{
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobAdvertDto jobAdvertDto) 
	{
		return this.jobAdvertService.add(jobAdvertDto);
	}
	
	
	@PostMapping("/updateIsConfirm")
	public Result updateIsConfirm(@RequestParam("isConfirm") boolean isConfirm, @RequestParam("id") int id)
	{
		return this.jobAdvertService.updateIsConfirm(isConfirm, id );
	}
	
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(@RequestParam int id)
	{
		return this.jobAdvertService.changeOpenToClose(id);
	}
	
	
	
	@PostMapping("/changeCloseToOpen")
	public Result changeCloseToOpen(@RequestParam int id)
	{
		return this.jobAdvertService.changeCloseToOpen(id);
	}
	
	
	
	@GetMapping("/findById")
	public DataResult<JobAdvert> findById(@RequestParam int id)	
	{
		return this.jobAdvertService.findById(id);
	}
	
	
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll()
	{		
		return this.jobAdvertService.getAll();
	}
	
	
	
	@GetMapping("/getAllOpenJobAdvertList")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList()
	{
		return this.jobAdvertService.getAllOpenJobAdvertList();
	}
	
	
	
	@GetMapping("/findAllByOrderByPublishedDateDesc")
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedAtDesc()
	{
		return this.jobAdvertService.findAllByOrderByPublishedDateDesc();
	}
	
	
	
	@GetMapping("/findAllByOrderByPublishedDateAsc")
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedDateAsc()
	{
		return this.jobAdvertService.findAllByOrderByPublishedDateAsc();		
	}
	
	
	
	@GetMapping("/getAllOpenJobAdvertByEmployer")
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(@RequestParam int id)
	{
		return this.jobAdvertService.getAllOpenJobAdvertByEmployer(id);
	}
	
	@GetMapping("/getByIsConfirm")
	public DataResult<List<JobAdvert>> getByIsActive(@RequestParam boolean isConfirm) 
	{
		return this.jobAdvertService.getByIsConfirm(isConfirm);
	}

	/*
	@GetMapping("/getByIsConfirmAndIsActive")
	public DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(@RequestParam boolean isConfirm,
			@RequestParam boolean isActive) 
	{
		return this.jobAdvertService.getByIsConfirmAndIsActive(isConfirm, isActive);
	}
	*/
	
	/*
	@PostMapping("/updateisactive")
	public Result updateIsActive(@RequestParam boolean isActive, @RequestParam int userId, @RequestParam int id) {
		return this.jobAdvertService.updateIsActive(isActive, userId, id);
	}

	@PostMapping("/updateisconfirm")
	public Result updateIsConfirm(@RequestParam boolean isConfirm, @RequestParam int id) {
		return this.jobAdvertService.updateIsConfirm(isConfirm, id);
	}
	*/
	
}
