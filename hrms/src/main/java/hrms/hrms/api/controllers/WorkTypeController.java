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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.WorkTypeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/worktype")
@CrossOrigin
public class WorkTypeController {
	
	private WorkTypeService workTypeService;

	@Autowired
	public WorkTypeController(WorkTypeService workTypeService) 
	{
		super();
		this.workTypeService = workTypeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody WorkType workType)
	{
		return ResponseEntity.ok(this.workTypeService.add(workType));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.workTypeService.getAll());
	}
	
}
