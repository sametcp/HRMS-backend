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

import hrms.hrms.business.abstracts.LinkForCVService;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.entities.dtos.LinkForCVDto;

@RestController
@RequestMapping("/api/links")
@CrossOrigin
public class LinkForCVController {
	
	private LinkForCVService linkForCVService;

	@Autowired
	public LinkForCVController(LinkForCVService linkForCVService)
	{
		super();
		this.linkForCVService = linkForCVService;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody LinkForCVDto linkForCVDto)
	{
		return ResponseEntity.ok(this.linkForCVService.add(linkForCVDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody LinkForCVDto linkForCVDto)
	{
		return ResponseEntity.ok(this.linkForCVService.update(linkForCVDto));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.linkForCVService.delete(id));
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?>getLinkForCVById(@RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.linkForCVService.getLinkForCVById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.linkForCVService.getAll());
	}
	
	@GetMapping("/getAllByJobseekerId")
	public ResponseEntity<?> getAllByJobseekerId(@RequestParam int id)
	{
		return ResponseEntity.ok(this.linkForCVService.getAllByJobseekerId(id));
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
