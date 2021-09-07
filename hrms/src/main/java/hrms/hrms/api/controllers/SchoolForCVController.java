package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.SchoolForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.SchoolForCV;
import hrms.hrms.entities.dtos.SchoolForCVDto;

@RestController
@RequestMapping("/api/schools")
public class SchoolForCVController {
	
	private SchoolForCVService schoolForCVService;

	@Autowired
	public SchoolForCVController(SchoolForCVService schoolForCVService) 
	{
		super();
		this.schoolForCVService = schoolForCVService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SchoolForCVDto schoolForCVDto) 
	{
		return this.schoolForCVService.add(schoolForCVDto);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody SchoolForCVDto schoolForCVDto){
		return this.schoolForCVService.update(schoolForCVDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id)
	{
		return this.schoolForCVService.delete(id);
	}
	
	
	@GetMapping("/getById")
	public DataResult<SchoolForCV> getById(@RequestParam int id
			){
		return this.schoolForCVService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<SchoolForCV>> getAll()
	{
		return this.schoolForCVService.getAll();
	}
	
	
	@GetMapping("/getByJobseekerId")
	public DataResult<List<SchoolForCV>> getByJobseekerId(@RequestParam int id)
	{
		return this.schoolForCVService.getByJobseekerId(id);
	}
	
	
	@GetMapping("/getAllDesc")
	DataResult<List<SchoolForCV>> getAllSorted(@RequestParam int id)
	{
		return this.schoolForCVService.getAllSorted(id);
	}
}