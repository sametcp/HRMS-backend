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

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.dtos.ProgrammingSkillForCVDto;

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
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.employerService.getAll());
	}
	
	@GetMapping("/getById")  // bilgileri database'den-kendimden veriyorum
	public ResponseEntity<?> getById(@RequestParam int id)
	{
		
		return ResponseEntity.ok(this.employerService.getById(id));
		
	}
	
	
	@PostMapping("/add")  // bilgileri requestbody'den alıyoruz
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer)
	 {
		return ResponseEntity.ok(this.employerService.add(employer));
	}
	
	@DeleteMapping("/delete")
    private ResponseEntity<?> delete(@RequestParam int id)
	{
        return ResponseEntity.ok(this.employerService.delete(id));
    }
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Employer employer)
	{
		return ResponseEntity.ok(this.employerService.update(employer));
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
