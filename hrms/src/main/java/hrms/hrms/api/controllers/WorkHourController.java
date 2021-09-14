package hrms.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.WorkHourService;
import hrms.hrms.entities.concretes.WorkHour;

@RestController
@RequestMapping("api/workhour")
@CrossOrigin
public class WorkHourController {
	
	private WorkHourService workHourService;

	@Autowired
	public WorkHourController(WorkHourService workHourService) {
		super();
		this.workHourService = workHourService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody WorkHour workHour) 
	{
		return ResponseEntity.ok(this.workHourService.add(workHour));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?>getAll()
	{
		return ResponseEntity.ok(this.workHourService.getAll());
	}
	
}
