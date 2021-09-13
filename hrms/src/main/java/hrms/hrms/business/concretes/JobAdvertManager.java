package hrms.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.JobAdvertService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.CityDao;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import hrms.hrms.dataAccess.abstracts.JobPositionsDao;
import hrms.hrms.dataAccess.abstracts.WorkHourDao;
import hrms.hrms.dataAccess.abstracts.WorkTypeDao;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDto;
import hrms.hrms.entities.dtos.JobAdvertFilter;

import org.springframework.data.domain.Sort;


@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao; // dataAccess
	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobPositionsDao jobPositionsDao;
	private WorkHourDao workHourDao;
	private WorkTypeDao workTypeDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, CityDao cityDao, EmployerDao employerDao, JobPositionsDao jobPositionsDao
			, WorkHourDao workHourDao, WorkTypeDao workTypeDao)
	{
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobPositionsDao = jobPositionsDao;
		this.workTypeDao = workTypeDao;
		this.workHourDao = workHourDao;
	}
	
	@Override
	public Result add(JobAdvertDto jobAdvertDto) 
	{
		
		JobAdvert jobAdvert = new JobAdvert();
		
		jobAdvert.setStatement(jobAdvertDto.getStatement());
		jobAdvert.setSalaryMin(jobAdvertDto.getSalaryMin());
		jobAdvert.setSalaryMax(jobAdvertDto.getSalaryMax());
		jobAdvert.setOpenPositionCount(jobAdvertDto.getOpenPositionCount());
		jobAdvert.setDeadline(jobAdvertDto.getDeadline());;
		jobAdvert.setPublishedDate(LocalDate.now());
		
		jobAdvert.setActive(false);
		jobAdvert.setConfirm(false);
		
		jobAdvert.setCity(this.cityDao.getById(jobAdvertDto.getCityId()));
		jobAdvert.setEmployer(this.employerDao.getById(jobAdvertDto.getEmployerId()));
		jobAdvert.setJobPositions(this.jobPositionsDao.getById(jobAdvertDto.getJobPositionId()));
		jobAdvert.setWorkHour(this.workHourDao.getById(jobAdvertDto.getWorkHourId()));
		jobAdvert.setWorkType(this.workTypeDao.getById(jobAdvertDto.getWorkTypeId()));
		
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Başarıyla eklendi");
	}
	
	@Override
	public Result update(JobAdvert jobAdvert) 
	{
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advert has been updated.");
	}

	
	@Override
	public Result delete(int id) 
	{
		this.jobAdvertDao.deleteById(id);  // id üzerinden direkt silinir.
		return new SuccessResult("Job advert has been deleted.");
	}
	
	
	@Override
	public DataResult<JobAdvert> findById(int id) 
	{
		return new SuccessDataResult<JobAdvert>
		(this.jobAdvertDao.getById(id));
	}

	 
	
	@Override
	public DataResult<List<JobAdvert>> getAll() 
	{
		
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll());
	}

	
	@Override
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedDateDesc()
	{
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAllByOrderByPublishedDateDesc());
	}

	
	
	@Override
	public DataResult<List<JobAdvert>> findAllByOrderByPublishedDateAsc()
	{
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByOrderByPublishedDateAsc());
	}
	
	
	@Override
	public DataResult<List<JobAdvert>> getByIsConfirm(boolean isConfirm) 
	{
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsConfirm(isConfirm));
	}
	
	
	@Override
	public DataResult<List<JobAdvert>> getByIsActive(boolean isActive) 
	{
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsActive(isActive));
	}
	

	@Override
	public Result updateIsConfirm(boolean isConfirm, int id) 
	{
		JobAdvert jobAdvertUpdate = this.jobAdvertDao.getById(id);
		jobAdvertUpdate.setConfirm(isConfirm);
		
		this.jobAdvertDao.save(jobAdvertUpdate);
		return new SuccessResult("İşlem başarılı.");
	}
	
	
	@Override
	public Result updateIsActive(boolean isActive, int id) 
	{
		JobAdvert jobAdvertUpdate = this.jobAdvertDao.getById(id);
		jobAdvertUpdate.setActive(isActive);
		
		this.jobAdvertDao.save(jobAdvertUpdate);
		return new SuccessResult("İşlem başarılı.");
	}

	
	@Override
	public DataResult<List<JobAdvert>> getByEmployer_Id(int id) 
	{
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByEmployer_Id(id));
	}

	
	@Override
	public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize) 
	{
		Pageable pageAble = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(pageAble).getContent(),"Sayfa işlemi başarılı"); 
	}

	
	@Override
	public DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, int pageNo,
			int pageSize) 
	{
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return new SuccessDataResult<List<JobAdvert>>(
		this.jobAdvertDao.getByIsConfirmAndIsActive(isConfirm, isActive, pageable).getContent(),
		this.jobAdvertDao.getByIsConfirmAndIsActive(isConfirm, isActive, pageable).getTotalPages()+"");
		
	}
	
	
	@Override
	public DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive) 
	{
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsConfirmAndIsActive(isConfirm, isActive));
	}

	
	@Override
	public DataResult<List<JobAdvert>> sortByCreatedDate() 
	{
		Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort),
		"Oluşturulma tarihine göre listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getByFilter(JobAdvertFilter jobAdvertFilter, int pageNo, int pageSize) 
	{
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvert>>(
		this.jobAdvertDao.getByFilter(jobAdvertFilter, pageable).getContent(),
		this.jobAdvertDao.getByFilter(jobAdvertFilter, pageable).getTotalPages() + "");
	}


}
