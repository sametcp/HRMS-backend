package hrms.hrms.api.controllers;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobPositionsService;
import hrms.hrms.core.utilities.results.ErrorDataResult;
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
	public ResponseEntity<?> getall()
	{
		
		return ResponseEntity.ok(this.jobPositionsService.getAll());
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPositions jobPositions)  
	{
		return ResponseEntity.ok(this.jobPositionsService.add(jobPositions));  
		// requestbody'deki bilgileri jobPositions şeklinde buradan parametreden alıyorum.
		// burdaki paketi de manager'deki metodu çağırarak oradan database'e save ediyorum.
		// değer döndüren bir metot olduğundan SuccessResult'a parametreli değer veriyorum.
		// ordaki işimi hallettikten sonra da bir şekilde değer döndürmem - bir yere bilgi göndermem gerek
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
