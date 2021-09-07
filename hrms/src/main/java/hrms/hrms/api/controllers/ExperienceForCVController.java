package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.ExperienceForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ExperienceForCV;
import hrms.hrms.entities.dtos.ExperienceForCVDto;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceForCVController {
	
	private ExperienceForCVService experienceForCVService; // business

	
	@Autowired
	public ExperienceForCVController(ExperienceForCVService experienceForCVService) {
		super();
		this.experienceForCVService = experienceForCVService;
	}

	
	// post metotlarım - aldıklarım
	
	@PostMapping("/add")
	public Result add(@RequestBody ExperienceForCVDto experienceForCVDto){
		return this.experienceForCVService.add(experienceForCVDto);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody ExperienceForCVDto experienceForCVDto){
		return this.experienceForCVService.update(experienceForCVDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.experienceForCVService.delete(id);
	}
	
	// databaseden aldıklarım - getlerim
	
	@GetMapping("/getById")
	public DataResult<ExperienceForCV> getById(@RequestParam int id){
		return this.experienceForCVService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ExperienceForCV>> getAll(){
		return this.experienceForCVService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<ExperienceForCV>> getAllByJobseekerId(@RequestParam int id){
		return this.experienceForCVService.getAllByJobseekerId(id);
	}
	
	@GetMapping("/getAllDesc")
	DataResult<List<ExperienceForCV>> getAllSorted()
	{
		return this.experienceForCVService.getAllSorted();
	}
}
