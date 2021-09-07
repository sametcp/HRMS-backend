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

import hrms.hrms.business.abstracts.CoverLetterForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CoverLetterForCV;
import hrms.hrms.entities.dtos.CoverLetterForCVDto;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLetterForCVController {
	
	private CoverLetterForCVService coverLetterForCVService;

	@Autowired
	public CoverLetterForCVController(CoverLetterForCVService coverLetterForCVService) 
	{
		super();
		this.coverLetterForCVService = coverLetterForCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterForCVDto coverLetterForCVDto)
	{
		return this.coverLetterForCVService.add(coverLetterForCVDto);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody CoverLetterForCVDto coverLetterForCVDto)
	{
		return this.coverLetterForCVService.update(coverLetterForCVDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id)
	{
		return this.coverLetterForCVService.delete(id);
	}
	
	
	
	
	@GetMapping("/getById")
	public DataResult<CoverLetterForCV> getById(@RequestParam("id") int id)
	{
		return this.coverLetterForCVService.getCoverLetterForCVById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CoverLetterForCV>> getAll()
	{
		return this.coverLetterForCVService.getAll();
	}
	
}
