package hrms.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms.business.abstracts.AuthService;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.Jobseeker;

@RestController
@RequestMapping("/api/verify")
@CrossOrigin
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	
	@PostMapping("/registerEmployer")
	public ResponseEntity<?> registerEmployer(@RequestBody Employer employer, String confirmPassword)
	{
		return ResponseEntity.ok(authService.registerEmployer(employer, confirmPassword));
	}
	
	
	@PostMapping("/registerJobseeker")
	public ResponseEntity<?> registerJobseeker(@RequestBody Jobseeker jobseeker, String confirmPassword)
	{
		return ResponseEntity.ok(authService.registerJobseeker(jobseeker, confirmPassword));
	}
	
}
