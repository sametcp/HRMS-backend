package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.ExperienceForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.ExperienceForCVDao;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.entities.concretes.ExperienceForCV;
import hrms.hrms.entities.dtos.ExperienceForCVDto;

@Service
public class ExperienceForCVManager implements ExperienceForCVService{
	
	private ExperienceForCVDao experienceForCVDao;
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public ExperienceForCVManager(ExperienceForCVDao experinceForCVDao, JobSeekerDao jobSeekerDao) {
		
		super();
		this.experienceForCVDao = experinceForCVDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(ExperienceForCVDto experienceForCVDto) 
	{
		ExperienceForCV experienceForCV = new ExperienceForCV();
		
		experienceForCV.setJobseeker(this.jobSeekerDao.getJobseekerById(experienceForCVDto.getJobseekerId()));
		experienceForCV.setWorkplace(experienceForCVDto.getWorkplace());
		experienceForCV.setPosition(experienceForCVDto.getPosition());
		experienceForCV.setStartDate(experienceForCVDto.getStartDate());
		experienceForCV.setEndDate(experienceForCVDto.getEndDate());
		
		this.experienceForCVDao.save(experienceForCV);
		return new SuccessResult("Bilgiler Kaydedildi");
		
	}

	@Override
	public Result update(ExperienceForCVDto experienceForCVDto)
	{
		ExperienceForCV experienceForCVUpdate = this.experienceForCVDao.getById(experienceForCVDto.getId());
		
		experienceForCVUpdate.setWorkplace(experienceForCVDto.getWorkplace());
		experienceForCVUpdate.setPosition(experienceForCVDto.getPosition());
		experienceForCVUpdate.setStartDate(experienceForCVDto.getStartDate());
		experienceForCVUpdate.setEndDate(experienceForCVDto.getEndDate());
		
		this.experienceForCVDao.save(experienceForCVUpdate);
		return new SuccessResult("Bilgiler Güncellendi");
	}

	@Override
	public Result delete(int id) 
	{
		this.experienceForCVDao.deleteById(id);
		return new SuccessResult("Experience has been deleted.");
	}

	@Override
	public DataResult<ExperienceForCV> getById(int id) 
	{
		return new SuccessDataResult<ExperienceForCV>
		(this.experienceForCVDao.getById(id));
	}

	@Override
	public DataResult<List<ExperienceForCV>> getAll() 
	{
		return new SuccessDataResult<List<ExperienceForCV>>(this.experienceForCVDao.findAll());
	}

	@Override
	public DataResult<List<ExperienceForCV>> getAllByJobseekerId(int id) {
		
		return new SuccessDataResult<List<ExperienceForCV>>(
				this.experienceForCVDao.getAllByJobseeker_id(id));
	}

	@Override
	public DataResult<List<ExperienceForCV>> getAllSorted() {
		
        Sort sort = Sort.by(Sort.Direction.DESC,"startDate");
		
		return new SuccessDataResult<List<ExperienceForCV>>
		(this.experienceForCVDao.findAll(sort),"Sıralama başarılı");
	}
	//  SORT AYRI BİR YÖNTEM. +++ ek
	
}
