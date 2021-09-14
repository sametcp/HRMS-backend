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

import hrms.hrms.business.abstracts.ExperienceForCVService;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.entities.dtos.ExperienceForCVDto;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperienceForCVController {
	
	private ExperienceForCVService experienceForCVService; // business

	
	@Autowired
	public ExperienceForCVController(ExperienceForCVService experienceForCVService) {
		super();
		this.experienceForCVService = experienceForCVService;
	}

	
	// post metotlarım - aldıklarım
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ExperienceForCVDto experienceForCVDto)
	{
		return ResponseEntity.ok(this.experienceForCVService.add(experienceForCVDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody ExperienceForCVDto experienceForCVDto)
	{
		return ResponseEntity.ok(this.experienceForCVService.update(experienceForCVDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.experienceForCVService.delete(id));
	}
	
	// databaseden aldıklarım - getlerim
	
	@GetMapping("/getById")
	public ResponseEntity<?>getById(@RequestParam int id)
	{
		return ResponseEntity.ok(this.experienceForCVService.getById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.experienceForCVService.getAll());
	}
	
	@GetMapping("/getAllByJobseekerId")
	public ResponseEntity<?> getAllByJobseekerId(@RequestParam int id)
	{
		return ResponseEntity.ok(this.experienceForCVService.getAllByJobseekerId(id));
	}
	
	@GetMapping("/getAllDesc")
	public ResponseEntity<?> getAllSorted()
	{
		return ResponseEntity.ok(this.experienceForCVService.getAllSorted());
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
