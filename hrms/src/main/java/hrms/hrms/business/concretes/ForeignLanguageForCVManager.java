package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.ForeignLanguageForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.ForeignLanguageForCVDao;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.entities.concretes.ForeignLanguageForCV;
import hrms.hrms.entities.dtos.ForeignLanguageForCVDto;

@Service
public class ForeignLanguageForCVManager implements ForeignLanguageForCVService{
	
	private ForeignLanguageForCVDao foreignLanguageForCVDao;
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public ForeignLanguageForCVManager(ForeignLanguageForCVDao foreignLanguageForCVDao, JobSeekerDao jobSeekerDao) 
	{
		super();
		this.foreignLanguageForCVDao = foreignLanguageForCVDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(ForeignLanguageForCVDto foreignLanguageForCVDto) 
	{
		ForeignLanguageForCV foreignLanguageForCV = new ForeignLanguageForCV();
		
		foreignLanguageForCV.setJobseeker(this.jobSeekerDao.getJobseekerById(foreignLanguageForCVDto.getJobseekerId()));
		foreignLanguageForCV.setLanguage(foreignLanguageForCVDto.getLanguage());
		foreignLanguageForCV.setLevel(foreignLanguageForCVDto.getLevel());
		
		this.foreignLanguageForCVDao.save(foreignLanguageForCV);
		return new SuccessResult("Bilgiler Eklendi.");
	}

	@Override
	public Result update(ForeignLanguageForCVDto foreignLanguageForCVDto)
	{
		ForeignLanguageForCV foreignLanguageForCVUpdate = this.foreignLanguageForCVDao.getById(foreignLanguageForCVDto.getId());
		
		foreignLanguageForCVUpdate.setLanguage(foreignLanguageForCVDto.getLanguage());
		foreignLanguageForCVUpdate.setLevel(foreignLanguageForCVDto.getLevel());
		
		this.foreignLanguageForCVDao.save(foreignLanguageForCVUpdate);
		return new SuccessResult("Bilgiler Güncellendi.");
	}

	@Override
	public Result delete(int id)
	{
		
		this.foreignLanguageForCVDao.deleteById(id);;
		return new SuccessResult("Foreign language has been deleted.");
	}

	@Override
	public DataResult<ForeignLanguageForCV> getForeignLanguageForCVById(int id) 
	{
		return new SuccessDataResult<ForeignLanguageForCV>
		(this.foreignLanguageForCVDao.getById(id));
	}

	@Override
	public DataResult<List<ForeignLanguageForCV>> getAll() 
	{
		return new SuccessDataResult<List<ForeignLanguageForCV>>
		(this.foreignLanguageForCVDao.findAll());
	}

	@Override
	public DataResult<List<ForeignLanguageForCV>> getAllByJobseekerId(int id) 
	{
		
		return new SuccessDataResult<List<ForeignLanguageForCV>>
		(this.foreignLanguageForCVDao.getAllByJobseeker_id(id));
	}
	
	
	
}
