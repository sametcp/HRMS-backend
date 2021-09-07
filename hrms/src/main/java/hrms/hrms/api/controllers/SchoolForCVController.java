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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.SchoolForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.SchoolForCV;
import hrms.hrms.entities.dtos.SchoolForCVDto;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolForCVController {
	
	private SchoolForCVService schoolForCVService;

	@Autowired
	public SchoolForCVController(SchoolForCVService schoolForCVService) 
	{
		super();
		this.schoolForCVService = schoolForCVService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody SchoolForCVDto schoolForCVDto) 
	{
		return this.schoolForCVService.add(schoolForCVDto);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody SchoolForCVDto schoolForCVDto){
		return ResponseEntity.ok(this.schoolForCVService.update(schoolForCVDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id)
	{
		return ResponseEntity.ok(this.schoolForCVService.delete(id));
	}
	
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id)
	{
		return ResponseEntity.ok(this.schoolForCVService.getById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?>getAll()
	{
		return ResponseEntity.ok(this.schoolForCVService.getAll());
	}
	
	
	@GetMapping("/getByJobseekerId")
	public ResponseEntity<?>getByJobseekerId(@RequestParam int id)
	{
		return ResponseEntity.ok(this.schoolForCVService.getByJobseekerId(id));
	}
	
	
	@GetMapping("/getAllDesc")
	public ResponseEntity<?> getAllSorted(@RequestParam int id)
	{
		return ResponseEntity.ok(this.schoolForCVService.getAllSorted(id));
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