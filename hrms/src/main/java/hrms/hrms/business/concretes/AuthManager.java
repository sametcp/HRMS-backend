package hrms.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.AuthService;
import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.business.abstracts.VerificationCodeService;
import hrms.hrms.core.utilities.adapters.ValidationService;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.core.verification.VerificationService;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.concretes.User;
import hrms.hrms.entities.concretes.VerificationCodes;

@Service
public class AuthManager implements AuthService{
	
	private EmployerService employerService;
	private JobseekerService jobseekerService;
	private ValidationService validationService;
	private VerificationService verificationService;
	private UserService userService;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public AuthManager(EmployerService employerService, JobseekerService jobseekerService,
			ValidationService validationService,VerificationService verificationService,
			UserService userService,VerificationCodeService verificationCodeService)
	{
		super();
		this.employerService = employerService;
		this.jobseekerService = jobseekerService;
		this.validationService = validationService;
		this.verificationService = verificationService;
		this.userService = userService;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		
		if (!checkIfNullInfoForEmployer(employer)) 
		{

			return new ErrorResult("Could not be added. You have entered missing information. Please fill in all fields.");
		}
		
		
		if (!checkIfEmailExists(employer.getEmail())) 
		{

			return new ErrorResult("Could not be added. " +  employer.getEmail() + " already exists.");
		}

		if (!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword))
		{

			return new ErrorResult("Could not be added. Passwords do not match.");
		}
		
		if (checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsite())) {

			return new ErrorResult("Invalid email address!");
		}
		
		

		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(employer.getId(), code, employer.getEmail());
		return new SuccessResult("Registration has been successfully completed");

	}

	@Override
	public Result registerJobseeker(Jobseeker jobseeker, String confirmPassword) 
	{
		if (checkIfRealPerson(jobseeker.getNationalId(), jobseeker.getFirstName(),
				jobseeker.getLastName(), jobseeker.getDateOfBirth().getYear()) == false) 
		{
			return new ErrorResult("Could not be added. TCKN could not be verified.");
		}

		if (!checkIfNullInfoForJobseeker(jobseeker, confirmPassword)) 
		{
			
			return new ErrorResult("Could not be added. You have entered missing information. Please fill in all fields.");
		}

		if (!checkIfExistsTcNo(jobseeker.getNationalId())) 
		{

			return new ErrorResult("Could not be added. " + jobseeker.getNationalId() + " already exists.");
		}

		if (!checkIfEmailExists(jobseeker.getEmail())) 
		{

			return new ErrorResult("Could not be added. " + jobseeker.getEmail() + " already exists.");
		}
		
		if (!checkIfEqualPasswordAndConfirmPassword(jobseeker.getPassword(), confirmPassword))
		{
			
			return new ErrorResult("Could not be added. Passwords do not match.");
		}
		
		
		jobseekerService.add(jobseeker);
		String code = verificationService.sendCode();
		verificationCodeRecord(jobseeker.getId(), code, jobseeker.getEmail());
		return new SuccessResult("Registration has been successfully completed");
		
	}
	
	
	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebsite() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) 
		{
			
			return true;
			
		}

		return false;
	}

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}
	
	
	private boolean checkIfNullInfoForJobseeker(Jobseeker jobseeker, String confirmPassword) {  // boş bilgi var mı?

		if (jobseeker.getFirstName() != null && jobseeker.getLastName() != null && jobseeker.getNationalId() != null
				&& jobseeker.getDateOfBirth() != null && jobseeker.getPassword() != null && jobseeker.getEmail() != null
				&& confirmPassword != null) 
		{

			return true;

		}

		return false;
	}
	
	
	
	private boolean checkIfExistsTcNo(String nationalId) {  // databasede başka bir kullanıcı var mı ?

		if (this.jobseekerService.getJobseekerByNationalId(nationalId).getData() == null)
		{
			return true;
		}
		
		return false;
	}
	
	
	private boolean checkIfRealPerson(String nationalId, String firstName, String lastName, int yearOfBirth) {

		if (validationService.validateByMernis(nationalId, firstName, lastName, yearOfBirth)) 
		{
			return true;
		}
		
		return false;
	}
	
	
	private boolean checkIfEmailExists(String email) {

		if (this.userService.getUserByEmail(email).getData() == null) 
		{

			return true;
		}

		return false;
	}
	
	private boolean checkIfWebsiteExists(String website) {

		if (this.employerService.getByWebsite(website) == null) 
		{

			return true;
		}

		return false;
	}

	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) 
		{
			return false;
		}

		return true;
	}
	
	
	private void verificationCodeRecord(int id, String code, String email) {
		
		VerificationCodes verificationCode = new VerificationCodes(id, code, false);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email );
	
	}

	@Override
	public Result login(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
