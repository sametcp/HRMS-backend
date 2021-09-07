package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.ForeignLanguageForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ForeignLanguageForCV;
import hrms.hrms.entities.dtos.ForeignLanguageForCVDto;

@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguageForCVController {
	
	private ForeignLanguageForCVService foreignLanguageForCVService; // business

	public ForeignLanguageForCVController(ForeignLanguageForCVService foreignLanguageForCVService) {
		super();
		this.foreignLanguageForCVService = foreignLanguageForCVService;
	}
	
	// postmapping metotlarım - dışarıdan aldıklarım
	
	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguageForCVDto foreignLanguageForCVDto){
		return this.foreignLanguageForCVService.add(foreignLanguageForCVDto);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody ForeignLanguageForCVDto foreignLanguageForCVDto){
		return this.foreignLanguageForCVService.update(foreignLanguageForCVDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.foreignLanguageForCVService.delete(id);
	}
	
	// getmapping metotlarım - databaseden aldıklarım
	
	@GetMapping("/getById")
	public DataResult<ForeignLanguageForCV> getById(@RequestParam("id") int id){
		return this.foreignLanguageForCVService.getForeignLanguageForCVById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ForeignLanguageForCV>> getAll(){
		return this.foreignLanguageForCVService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<ForeignLanguageForCV>> getAllByJobseekerId(@RequestParam int id){
		return this.foreignLanguageForCVService.getAllByJobseekerId(id);
	}
}
