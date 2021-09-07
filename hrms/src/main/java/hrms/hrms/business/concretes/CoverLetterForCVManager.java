package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.CoverLetterForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CoverLetterForCVDao;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.entities.concretes.CoverLetterForCV;
import hrms.hrms.entities.dtos.CoverLetterForCVDto;

@Service
public class CoverLetterForCVManager implements CoverLetterForCVService{
	
	private CoverLetterForCVDao coverLetterForCVDao;  // dataaccess
	private JobSeekerDao jobSeekerDao;

	public CoverLetterForCVManager(CoverLetterForCVDao coverLetterForCVDao, JobSeekerDao jobSeekerDao) {
		super();
		this.coverLetterForCVDao = coverLetterForCVDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	
	@Override
	public Result add(CoverLetterForCVDto coverLetterForCVDto) 
	{
		CoverLetterForCV coverLetterForCV = new CoverLetterForCV();
		
		coverLetterForCV.setJobseeker(this.jobSeekerDao.getJobseekerById(coverLetterForCVDto.getJobseekerId()));
		coverLetterForCV.setContent(coverLetterForCVDto.getContent());
		
		this.coverLetterForCVDao.save(coverLetterForCV);
		return new SuccessResult("Bilgiler Eklendi.");
	}

	
	@Override
	public Result update(CoverLetterForCVDto coverLetterForCVDto) 
	{
		CoverLetterForCV coverLetterForCVUpdate = this.coverLetterForCVDao.getById(coverLetterForCVDto.getId());
		
		coverLetterForCVUpdate.setContent(coverLetterForCVDto.getContent());
		
		this.coverLetterForCVDao.save(coverLetterForCVUpdate);
		return new SuccessResult("Bilgiler Güncellendi.");
	}

	
	@Override
	public Result delete(int id)
	{
		this.coverLetterForCVDao.deleteById(id);
        return new SuccessResult("Cover letter has been deleted.");
	}

	
	@Override
	public DataResult<CoverLetterForCV> getCoverLetterForCVById(int id) 
	{
		return new SuccessDataResult<CoverLetterForCV>
		(this.coverLetterForCVDao.getById(id));
	}

	
	@Override
	public DataResult<List<CoverLetterForCV>> getAll() 
	{
		return new SuccessDataResult<List<CoverLetterForCV>>
		(this.coverLetterForCVDao.findAll());
	}


	@Override
	public DataResult<List<CoverLetterForCV>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<CoverLetterForCV>>
		(this.coverLetterForCVDao.getAllByJobseeker_id(id));
	}
	
}
