package hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.CityService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {
	
	private CityService cityService;  // business

	@Autowired
	public CityController(CityService cityService)
	{
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(this.cityService.getAll());
	}
	
}
