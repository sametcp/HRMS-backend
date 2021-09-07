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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
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
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertDto jobAdvertDto) 
	{
		return ResponseEntity.ok(this.jobAdvertService.add(jobAdvertDto));
	}
	
	
	@PutMapping("/updateIsConfirm")
	public ResponseEntity<?> updateIsConfirm(@RequestParam("isConfirm") boolean isConfirm, @RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.jobAdvertService.updateIsConfirm(isConfirm, id ));
	}
	
	@PutMapping("/updateIsActive")
	public ResponseEntity<?> updateIsActive(@RequestParam("isActive") boolean isActive, @RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.jobAdvertService.updateIsActive(isActive, id ));
	}
	
	
	@GetMapping("/findById")
	public ResponseEntity<?> findById(@RequestParam int id)	
	{
		return ResponseEntity.ok(this.jobAdvertService.findById(id));
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll()
	{		
		return ResponseEntity.ok(this.jobAdvertService.getAll());
	}
		
	
	@GetMapping("/findAllByOrderByPublishedDateDesc")
	public ResponseEntity<?> findAllByOrderByPublishedAtDesc()
	{
		return ResponseEntity.ok(this.jobAdvertService.findAllByOrderByPublishedDateDesc());
	}
	
	
	@GetMapping("/findAllByOrderByPublishedDateAsc")
	public ResponseEntity<?> findAllByOrderByPublishedDateAsc()
	{
		return ResponseEntity.ok(this.jobAdvertService.findAllByOrderByPublishedDateAsc());		
	}
	
	
	@GetMapping("/getByIsConfirm")
	public ResponseEntity<?> getByIsConfirm(@RequestParam boolean isConfirm) 
	{
		return ResponseEntity.ok(this.jobAdvertService.getByIsConfirm(isConfirm));
	}
	
	
	@GetMapping("/getByIsActive")
	public ResponseEntity<?> getByIsActive(@RequestParam boolean isActive) 
	{
		return ResponseEntity.ok(this.jobAdvertService.getByIsActive(isActive));
	}
	
	
	@GetMapping("/getAllByPage")
	public ResponseEntity<?> getAll(int pageNo, int pageSize)
	{
		return ResponseEntity.ok(this.jobAdvertService.getAll(pageNo, pageSize));
	}

	
	@GetMapping("/getByIsConfirmedAndIsActiveWithPage")
	public ResponseEntity<?> getByIsConfirmAndIsActiveWithPage(@RequestParam boolean isConfirm,
			@RequestParam boolean isActive, @RequestParam int pageNo, @RequestParam int pageSize) 
	{
		return ResponseEntity.ok(this.jobAdvertService.getByIsConfirmAndIsActive(isConfirm, isActive, pageNo, pageSize));
	}
	
	
	@GetMapping("/getByIsConfirmedAndIsActive")
	public ResponseEntity<?> getByIsConfirmAndIsActive(@RequestParam boolean isConfirm, @RequestParam boolean isActive) 
	{
		return ResponseEntity.ok(this.jobAdvertService.getByIsConfirmAndIsActive(isConfirm, isActive));
	}
	
	
	@GetMapping("/sortByCreatedDate")
	public ResponseEntity<?> sortByCreatedDate() 
	{
		return ResponseEntity.ok(this.jobAdvertService.sortByCreatedDate());
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
