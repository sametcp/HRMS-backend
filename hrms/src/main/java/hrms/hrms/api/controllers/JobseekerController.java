package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.dtos.JobSeekerCVDto;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobseekerController {
	
	private JobseekerService jobseekerService;
	
	@Autowired
	public JobseekerController(JobseekerService jobseekerService) 
	{
		super();
		this.jobseekerService = jobseekerService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Jobseeker jobseeker)
	{
		return this.jobseekerService.add(jobseeker);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id)
	{
		return this.jobseekerService.delete(id);
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Jobseeker>> getAll()
	{
		return this.jobseekerService.getAll();
	}
	
	
	@GetMapping("/getJobseekerCVById")
	public DataResult<JobSeekerCVDto> getJobseekerCVById(@RequestParam int id)
	{
		return this.jobseekerService.getJobseekerCVById(id);
	}
	
	@GetMapping("/getJobSeekerByNationalId")
	public DataResult<Jobseeker> getJobSeekerByNationalId(@RequestParam String id)
	{
		return this.jobseekerService.getJobseekerByNationalId(id);
	}
	
}
