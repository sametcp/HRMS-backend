package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.WorkHourService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody WorkHour workHour) 
	{
		return this.workHourService.add(workHour);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkHour>> getAll()
	{
		return this.workHourService.getAll();
	}
	
}