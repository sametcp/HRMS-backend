package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.SchoolForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.dataAccess.abstracts.SchoolForCVDao;
import hrms.hrms.entities.concretes.SchoolForCV;
import hrms.hrms.entities.dtos.SchoolForCVDto;

@Service
public class SchoolForCVManager implements SchoolForCVService{

	private SchoolForCVDao schoolForCVDao;
	private JobSeekerDao jobSeekerDao;
		
	@Autowired
	public SchoolForCVManager(SchoolForCVDao schoolForCVDao, JobSeekerDao jobSeekerDao) {
		super();
		this.schoolForCVDao = schoolForCVDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(SchoolForCVDto schoolForCVDto) 
	{
		SchoolForCV schoolForCV = new SchoolForCV();
		
		schoolForCV.setJobseeker(this.jobSeekerDao.getJobseekerById(schoolForCVDto.getJobseekerId()));
		schoolForCV.setSchoolName(schoolForCVDto.getSchoolName());
		schoolForCV.setDepartment(schoolForCVDto.getDepartment());
		schoolForCV.setStartDate(schoolForCVDto.getStartDate());
		schoolForCV.setEndDate(schoolForCVDto.getEndDate());
		
		this.schoolForCVDao.save(schoolForCV);
		return new SuccessResult("Bilgiler Eklendi.");
	}

	@Override
	public Result update(SchoolForCVDto schoolForCVDto) 
	{
		
		SchoolForCV schoolForCVUpdate = this.schoolForCVDao.getById(schoolForCVDto.getId());
		
		schoolForCVUpdate.setSchoolName(schoolForCVDto.getSchoolName());
		schoolForCVUpdate.setDepartment(schoolForCVDto.getDepartment());
		schoolForCVUpdate.setStartDate(schoolForCVDto.getStartDate());
		schoolForCVUpdate.setEndDate(schoolForCVDto.getEndDate());
		
		this.schoolForCVDao.save(schoolForCVUpdate);
		return new SuccessResult("Bilgiler Güncellendi.");
		
	}

	@Override
	public Result delete(int id)
	{
		this.schoolForCVDao.deleteById(id);
		return new SuccessResult("Okul başarıyla silindi.");
	}

	@Override
	public DataResult<SchoolForCV> getById(int id) 
	{
		return new SuccessDataResult<SchoolForCV>(this.schoolForCVDao.getById(id));
	}

	@Override
	public DataResult<List<SchoolForCV>> getAll() 
	{
		return new SuccessDataResult<List<SchoolForCV>>(this.schoolForCVDao.findAll());
	}

	@Override
	public DataResult<List<SchoolForCV>> getByJobseekerId(int id) 
	{
		return new SuccessDataResult<List<SchoolForCV>>(this.schoolForCVDao.getAllByJobseeker_id(id));
	}

	@Override
	public DataResult<List<SchoolForCV>> getAllSorted(int id) 
	{
		return new SuccessDataResult<List<SchoolForCV>>(this.schoolForCVDao.getAllByJobseeker_IdOrderByEndDateDesc(id));
	}
}
