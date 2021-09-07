package hrms.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import hrms.hrms.business.abstracts.ForeignLanguageForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ForeignLanguageForCV;
import hrms.hrms.entities.dtos.ForeignLanguageForCVDto;

@RestController
@RequestMapping("/api/foreignlanguages")
@CrossOrigin
public class ForeignLanguageForCVController {
	
	private ForeignLanguageForCVService foreignLanguageForCVService; // business

	public ForeignLanguageForCVController(ForeignLanguageForCVService foreignLanguageForCVService) {
		super();
		this.foreignLanguageForCVService = foreignLanguageForCVService;
	}
	
	// postmapping metotlarım - dışarıdan aldıklarım
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ForeignLanguageForCVDto foreignLanguageForCVDto)
	{
		return ResponseEntity.ok(this.foreignLanguageForCVService.add(foreignLanguageForCVDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody ForeignLanguageForCVDto foreignLanguageForCVDto)
	{
		return ResponseEntity.ok(this.foreignLanguageForCVService.update(foreignLanguageForCVDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.foreignLanguageForCVService.delete(id));
	}
	
	// getmapping metotlarım - databaseden aldıklarım
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.foreignLanguageForCVService.getForeignLanguageForCVById(id));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.foreignLanguageForCVService.getAll());
	}
	
	@GetMapping("/getAllByJobseekerId")
	public ResponseEntity<?> getAllByJobseekerId(@RequestParam int id)
	{
		return ResponseEntity.ok(this.foreignLanguageForCVService.getAllByJobseekerId(id));
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
