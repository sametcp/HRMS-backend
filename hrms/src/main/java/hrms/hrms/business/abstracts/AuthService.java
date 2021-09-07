package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.Jobseeker;

public interface AuthService {
	
	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerJobseeker(Jobseeker jobseeker, String confirmPassword);
	
	
}
