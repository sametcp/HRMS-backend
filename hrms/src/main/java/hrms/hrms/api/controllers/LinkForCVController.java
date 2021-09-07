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

import hrms.hrms.business.abstracts.LinkForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.LinkForCV;
import hrms.hrms.entities.dtos.LinkForCVDto;

@RestController
@RequestMapping("/api/links")
public class LinkForCVController {
	
	private LinkForCVService linkForCVService;

	@Autowired
	public LinkForCVController(LinkForCVService linkForCVService)
	{
		super();
		this.linkForCVService = linkForCVService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody LinkForCVDto linkForCVDto)
	{
		return this.linkForCVService.add(linkForCVDto);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody LinkForCVDto linkForCVDto)
	{
		return this.linkForCVService.update(linkForCVDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id)
	{
		return this.linkForCVService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<LinkForCV> getLinkForCVById(@RequestParam("id") int id)
	{
		return this.linkForCVService.getLinkForCVById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<LinkForCV>> getAll()
	{
		return this.linkForCVService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<LinkForCV>> getAllByJobseekerId(@RequestParam int id)
	{
		return this.linkForCVService.getAllByJobseekerId(id);
	}
	
}
