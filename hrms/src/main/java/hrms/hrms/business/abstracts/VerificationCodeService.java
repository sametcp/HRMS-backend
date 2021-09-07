package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.VerificationCodes;

public interface VerificationCodeService {
	
	Result add(VerificationCodes code);
	
}
