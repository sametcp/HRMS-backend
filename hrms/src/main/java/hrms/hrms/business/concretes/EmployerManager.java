package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employer;
import hrms.hrms.entities.concretes.JobAdvert;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao)
	{
		super();
		this.employerDao = employerDao;
	}
	
	
	@Override
	public DataResult<List<Employer>> getAll()
	{
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Data listelendi");
	}
	
	
	@Override
	public Result add(Employer employer) 
	{
		this.employerDao.save(employer);
		return new SuccessResult("İşveren eklendi");
	}
	

	@Override
	public Result update(Employer employer) 
	{
		this.employerDao.save(employer);
		return new SuccessResult("İşveren eklendi");
	}


	@Override
	public Result delete(int id) 
	{
		this.employerDao.deleteById(id);
		return new SuccessResult("Employer deleted successfully.");
	}


	@Override
	public Result getByWebsite(String website) 
	{
		
		this.employerDao.getByWebsite(website);
		return new SuccessResult("Website getirildi");
		
	}


	@Override
	public DataResult<Employer> getById(int id) 
	{
		return new SuccessDataResult<Employer>
		(this.employerDao.getById(id));
	}

	
}