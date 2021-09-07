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

import hrms.hrms.business.abstracts.ProgrammingSkillForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ProgrammingSkillForCV;
import hrms.hrms.entities.dtos.ProgrammingSkillForCVDto;

@RestController
@RequestMapping("/api/programmingskills")
public class ProgrammingSkillForCVController {
	
	private ProgrammingSkillForCVService programmingSkillForCVService;

	@Autowired
	public ProgrammingSkillForCVController(ProgrammingSkillForCVService programmingSkillForCVService) 
	{
		super();
		this.programmingSkillForCVService = programmingSkillForCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingSkillForCVDto programmingSkillForCVDto)
	{
		return this.programmingSkillForCVService.add(programmingSkillForCVDto);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody ProgrammingSkillForCVDto programmingSkillForCVDto)
	{
		return this.programmingSkillForCVService.update(programmingSkillForCVDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id)
	{
		return this.programmingSkillForCVService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<ProgrammingSkillForCV> getById(@RequestParam("id") int id)
	{
		return this.programmingSkillForCVService.getProgrammingSkillForCVById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ProgrammingSkillForCV>> getAll()
	{
		return this.programmingSkillForCVService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<ProgrammingSkillForCV>> getAllByJobseekerId(@RequestParam int id){
		
		return this.programmingSkillForCVService.getAllByJobseekerId(id);
	}
	
}
