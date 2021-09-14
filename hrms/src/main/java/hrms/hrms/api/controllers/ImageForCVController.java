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
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.ImageForCVService;
import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ImageForCV;
import hrms.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageForCVController {
	
	private ImageForCVService imageForCVService;
	private JobseekerService jobseekerService;
	
	@Autowired
	public ImageForCVController(ImageForCVService imageForCVService, JobseekerService jobseekerService)
	{
		super();
		this.imageForCVService = imageForCVService;
		this.jobseekerService = jobseekerService;
	}
	
	
	// @PostMapping(value = "/add")
	// public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile)
	
	
	@PostMapping("/add")
	public Result add(@RequestParam("jobSeekerId") int id, @RequestParam("imageFile") MultipartFile imageFile)
	{
		Jobseeker jobseeker = this.jobseekerService.getJobseekerById(id).getData();
		ImageForCV imageForCV = new ImageForCV();
		imageForCV.setJobseeker(jobseeker);
		return this.imageForCVService.add(id, imageForCV, imageFile);
	}
	

	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody ImageForCV imageForCV)
	{
		return ResponseEntity.ok(this.imageForCVService.update(imageForCV));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.imageForCVService.delete(id));
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam("id") int id)
	{
		return ResponseEntity.ok(this.imageForCVService.getImageForCVById(id));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.imageForCVService.getAll());
	}
	
	
	@GetMapping("/getByJobseekerId")
	public DataResult<ImageForCV> getByJobseekerId(@RequestParam int id)
	{
		return this.imageForCVService.getByJobseekerId(id);
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
