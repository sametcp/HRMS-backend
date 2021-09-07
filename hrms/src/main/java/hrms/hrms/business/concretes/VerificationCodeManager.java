package hrms.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.VerificationCodeService;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.VerificationCodeDao;
import hrms.hrms.entities.concretes.VerificationCodes;

@Service
public class VerificationCodeManager implements VerificationCodeService{
	
	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) 
	{
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCodes code) 
	{
		this.verificationCodeDao.save(code);
		return new SuccessResult("Code has been saved.");
	}
	
}
