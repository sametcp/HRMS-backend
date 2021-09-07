package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobSeekerFavoriteJobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.dataAccess.abstracts.JobSeekerFavoriteJobAdvertDao;
import hrms.hrms.entities.concretes.JobSeekerFavoriteJobAdverts;
import hrms.hrms.entities.dtos.JobSeekerFavoriteJobAdvertDto;

@Service
public class JobSeekerFavoriteJobAdvertManager implements JobSeekerFavoriteJobAdvertService{
	
	private JobSeekerFavoriteJobAdvertDao jobSeekerFavoriteJobAdvertDao;
	private JobAdvertDao jobAdvertDao;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerFavoriteJobAdvertManager(JobSeekerFavoriteJobAdvertDao jobSeekerFavoriteJobAdvertDao,
			JobAdvertDao jobAdvertDao, JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerFavoriteJobAdvertDao = jobSeekerFavoriteJobAdvertDao;
		this.jobAdvertDao = jobAdvertDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeekerFavoriteJobAdvertDto jobSeekerFavoriteJobAdvertDto) 
	{
		JobSeekerFavoriteJobAdverts jobSeekerFavoriteJobAdverts = new JobSeekerFavoriteJobAdverts();
		
		jobSeekerFavoriteJobAdverts.setJobseeker(this.jobSeekerDao.getJobseekerById(jobSeekerFavoriteJobAdvertDto.getJobseekerId()));
		jobSeekerFavoriteJobAdverts.setJobAdvert(this.jobAdvertDao.getById(jobSeekerFavoriteJobAdvertDto.getJobAdvertId()));
		
		this.jobSeekerFavoriteJobAdvertDao.save(jobSeekerFavoriteJobAdverts);
		return new SuccessResult("Favori İlan Eklendi");
	}

	@Override
	public Result delete(int id) 
	{
		this.jobSeekerFavoriteJobAdvertDao.deleteById(id);
		return new SuccessResult("Favorilerdeden Çıkarıldı");
	}

	@Override
	public DataResult<List<JobSeekerFavoriteJobAdverts>> getByJobseekerId(int id) 
	{
		return new SuccessDataResult<List<JobSeekerFavoriteJobAdverts>>(this.jobSeekerFavoriteJobAdvertDao.getAllByJobseeker_Id(id));

	}
	
	
	
}
