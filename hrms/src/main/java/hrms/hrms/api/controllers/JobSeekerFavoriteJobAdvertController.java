package hrms.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.PostRemove;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.JobSeekerFavoriteJobAdvertService;
import hrms.hrms.business.concretes.JobSeekerFavoriteJobAdvertManager;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.entities.dtos.JobSeekerFavoriteJobAdvertDto;

@RestController
@RequestMapping("api/jobSeekerFavoriteJobAdvertController")
@CrossOrigin
public class JobSeekerFavoriteJobAdvertController {
	
	private JobSeekerFavoriteJobAdvertService jobSeekerFavoriteJobAdvertService;

	@Autowired
	public JobSeekerFavoriteJobAdvertController(JobSeekerFavoriteJobAdvertService jobSeekerFavoriteJobAdvertService) {
		super();
		this.jobSeekerFavoriteJobAdvertService = jobSeekerFavoriteJobAdvertService;
	}
	
	@PostMapping("/add")
	private ResponseEntity<?> add(@RequestBody JobSeekerFavoriteJobAdvertDto jobSeekerFavoriteJobAdvertDto)
	{
        return ResponseEntity.ok(this.jobSeekerFavoriteJobAdvertService.add(jobSeekerFavoriteJobAdvertDto));
    }
	
	
	@DeleteMapping("/delete")
    private ResponseEntity<?> delete(@RequestParam int id)
	{
        return ResponseEntity.ok(this.jobSeekerFavoriteJobAdvertService.delete(id));
    }
	
	 @GetMapping("/getByJobseekerId")
	 private ResponseEntity<?> getByJobseekerId(@RequestParam int jobSeekerId)
	 {
	     return ResponseEntity.ok(this.jobSeekerFavoriteJobAdvertService.getByJobseekerId(jobSeekerId));
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
