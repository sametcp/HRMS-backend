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
import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.business.abstracts.ImageForCVService;
import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ImageForCV;
import hrms.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/images")
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
	public Result update(@RequestBody ImageForCV imageForCV, int id)
	{
		return this.imageForCVService.update(imageForCV);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id)
	{
		return this.imageForCVService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<ImageForCV> getById(@RequestParam("id") int id)
	{
		return this.imageForCVService.getImageForCVById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ImageForCV>> getAll()
	{
		return this.imageForCVService.getAll();
	}
	
	
	@GetMapping("/getByJobseekerId")
	public DataResult<ImageForCV> getByJobseekerId(@RequestParam int id)
	{
		return this.imageForCVService.getByJobseekerId(id);
	}
	
}
