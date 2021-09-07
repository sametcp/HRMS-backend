package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.ProgrammingSkillForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.dataAccess.abstracts.ProgrammingSkillForCVDao;
import hrms.hrms.entities.concretes.ProgrammingSkillForCV;
import hrms.hrms.entities.dtos.ProgrammingSkillForCVDto;

@Service
public class ProgrammingSkillForCVManager implements ProgrammingSkillForCVService{
	
	private ProgrammingSkillForCVDao programmingSkillForCVDao;
	private JobSeekerDao jobSeekerDao;
	

	@Autowired
	public ProgrammingSkillForCVManager(ProgrammingSkillForCVDao programmingSkillForCVDao, JobSeekerDao jobSeekerDao) 
	{
		super();
		this.programmingSkillForCVDao = programmingSkillForCVDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	/*
	@Override
	public Result add(ProgrammingSkillForCV programmingSkillForCV) 
	{	
		this.programmingSkillForCVDao.save(programmingSkillForCV);
		return new SuccessResult("Bilgiler Eklendi");
		
	}
	
	
	@Override
	public Result update(ProgrammingSkillForCV programmingSkillForCV) 
	{
		this.programmingSkillForCVDao.save(programmingSkillForCV);
		return new SuccessResult("Programming skill has been updated.");
	}
	
	*/
	 
	@Override
	public Result add(ProgrammingSkillForCVDto programmingSkillForCVDto) 
	{
		ProgrammingSkillForCV programmingSkillForCV = new ProgrammingSkillForCV();
		
		programmingSkillForCV.setJobseeker(this.jobSeekerDao.getJobseekerById(programmingSkillForCVDto.getJobseekerId()));
		programmingSkillForCV.setSkillName(programmingSkillForCVDto.getSkillName());
		
		this.programmingSkillForCVDao.save(programmingSkillForCV);
		return new SuccessResult("Bilgiler eklendi.");
	}

	@Override
	public Result update(ProgrammingSkillForCVDto programmingSkillForCVDto) 
	{
		ProgrammingSkillForCV programmingSkillForCVUpdate = this.programmingSkillForCVDao.getById(programmingSkillForCVDto.getId());
		
		programmingSkillForCVUpdate.setSkillName(programmingSkillForCVDto.getSkillName());
		
		this.programmingSkillForCVDao.save(programmingSkillForCVUpdate);
		return new SuccessResult("Bilgiler Güncellendi");
		
	}
	 
	@Override
	public Result delete(int id) {
		this.programmingSkillForCVDao.deleteById(id);
		return new SuccessResult("Programming skill has been deleted.");
	}

	@Override
	public DataResult<ProgrammingSkillForCV> getProgrammingSkillForCVById(int id) 
	{
		return new SuccessDataResult<ProgrammingSkillForCV>
		(this.programmingSkillForCVDao.getById(id));
	}

	@Override
	public DataResult<List<ProgrammingSkillForCV>> getAll() 
	{
		return new SuccessDataResult<List<ProgrammingSkillForCV>>
		(this.programmingSkillForCVDao.findAll());
	}

	@Override
	public DataResult<List<ProgrammingSkillForCV>> getAllByJobseekerId(int id) 
	{
		return new SuccessDataResult<List<ProgrammingSkillForCV>>
		(this.programmingSkillForCVDao.getAllByJobseeker_id(id));
	}

	
}
