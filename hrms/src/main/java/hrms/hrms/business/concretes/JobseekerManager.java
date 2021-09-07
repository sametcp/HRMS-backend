package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.ExperienceForCVService;
import hrms.hrms.business.abstracts.ForeignLanguageForCVService;
import hrms.hrms.business.abstracts.ImageForCVService;
import hrms.hrms.business.abstracts.JobseekerService;
import hrms.hrms.business.abstracts.LinkForCVService;
import hrms.hrms.business.abstracts.ProgrammingSkillForCVService;
import hrms.hrms.business.abstracts.SchoolForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.dtos.JobSeekerCVDto;

@Service
public class JobseekerManager implements JobseekerService{
	
	private JobSeekerDao jobseekerDao;


	@Autowired
	public JobseekerManager(JobSeekerDao jobseekerDao, ExperienceForCVService experienceForCVService,
			ForeignLanguageForCVService foreignLanguageForCVService, ImageForCVService imageForCVService,
			LinkForCVService linkForCVService, ProgrammingSkillForCVService programmingSkillForCVService,
			SchoolForCVService schoolForCVService) 
	{
		super();
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public Result add(Jobseeker jobseeker) 
	{
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been added.");
	}

	@Override
	public Result update(Jobseeker jobseeker) 
	{
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult("Jobseeker has been updated.");
	}

	@Override
	public Result delete(int id)
	{
		this.jobseekerDao.deleteById(id);
		return new SuccessResult("Jobseeker has been deleted.");
	}

	@Override
	public DataResult<Jobseeker> getJobseekerById(int id) 
	{
		return new SuccessDataResult<Jobseeker>
		(this.jobseekerDao.getJobseekerById(id));
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() 
	{
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll());
	}

	@Override
	public DataResult<Jobseeker> getJobseekerByNationalId(String nationalId) 
	{
		return new SuccessDataResult<Jobseeker>(this.jobseekerDao.findJobseekerByNationalId(nationalId));
	}

	@Override
	public DataResult<JobSeekerCVDto> getJobseekerCVById(int id) 
	{
		Jobseeker jobseeker = this.jobseekerDao.getJobseekerById(id);
		JobSeekerCVDto cv = new JobSeekerCVDto();
		
		cv.experiences = jobseeker.getExperiences();
		cv.programingSkills = jobseeker.getProgramingSkills();
		cv.schools = jobseeker.getSchools();
		cv.image = jobseeker.getImage();
		cv.languages = jobseeker.getLanguages();
		cv.links = jobseeker.getLinks();
		return new SuccessDataResult<JobSeekerCVDto>(cv);
	}
	
}
