package hrms.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
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
	public ResponseEntity<?> add(@Valid @RequestBody Jobseeker jobseeker)
	{
		return ResponseEntity.ok(this.jobseekerService.add(jobseeker));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Jobseeker jobseeker) {
		return ResponseEntity.ok(this.jobseekerService.update(jobseeker));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.jobseekerService.delete(id));
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.jobseekerService.getAll());
	}
	
	
	@GetMapping("/getJobseekerCVById")
	public ResponseEntity<?> getJobseekerCVById(@RequestParam int id)
	{
		return ResponseEntity.ok(this.jobseekerService.getJobseekerCVById(id));
	}
	
	@GetMapping("/getJobSeekerByNationalId")
	public ResponseEntity<?> getJobSeekerByNationalId(@RequestParam String id)
	{
		return ResponseEntity.ok(this.jobseekerService.getJobseekerByNationalId(id));
	}
	
	@GetMapping("/getJobseekerById")
	public ResponseEntity<?> getJobseekerById(@RequestParam int id)
	{
		return ResponseEntity.ok(this.jobseekerService.getJobseekerById(id));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
	
}
