package hrms.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/*
	@Override
	public Result add(JobAdvert jobAdvert) 
	{
	
		if (!CheckIfNullField(jobAdvert))
		{
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
		
		
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advert has been added.");
	}
	*/
	
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
	public Result changeOpenToClose(int id) 
	{
		if (findById(id) == null) 
		{
			return new ErrorResult("There is no such job advert");

		}
		
		else if (findById(id).getData().isOpen() == false) 
		{
			return new ErrorResult("There job advert is already closed.");
		}

		JobAdvert jobAdvert = findById(id).getData();
		
		jobAdvert.setOpen(false);
		update(jobAdvert);
		return new SuccessResult("Job advert has been successfully closed.");
	}
	
	
	public Result changeCloseToOpen (int id) 
	{
		
		if (findById(id) == null) 
		{
			return new ErrorResult("There is no such job advert");

		}
		
		else if (findById(id).getData().isOpen() == true) 
		{
			return new ErrorResult("There job advert is already opened.");
		}

		JobAdvert jobAdvert = findById(id).getData();
		
		jobAdvert.setOpen(true);
		update(jobAdvert);
		return new SuccessResult("Job advert has been successfully opened.");
	}
	
	
	@Override
	public DataResult<JobAdvert> findById(int id) 
	{
		return new SuccessDataResult<JobAdvert>
		(this.jobAdvertDao.getById(id));
	}

	 
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll());
	}

	
	
	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() 
	{
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllOpenJobAdvertList());
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
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id)
	{
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllOpenJobAdvertByEmployer(id));
	}

	
	/*
	private boolean CheckIfNullField(JobAdvert jobAdvert)
	{
		if (jobAdvert.getJobPositions() != null && jobAdvert.getStatement()!= null && jobAdvert.getCity() != null
				&& jobAdvert.getOpenPositionCount() != 0) 
		{
			return true;
		}
		
		
		return false;
	}
	*/

	@Override
	public DataResult<List<JobAdvert>> getByIsConfirm(boolean isConfirm) 
	{
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsConfirm(isConfirm));
	}
	
	@Override
	public DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive) 
	{
		return new SuccessDataResult<List<JobAdvert>>(
		this.jobAdvertDao.getByIsConfirmAndIsActive(isConfirm, isActive));
	}

	@Override
	public Result updateIsConfirm(boolean isConfirm, int id) 
	{
		JobAdvert jobAdvertUpdate = this.jobAdvertDao.getById(id);
		jobAdvertUpdate.setConfirm(isConfirm);
		
		this.jobAdvertDao.save(jobAdvertUpdate);
		return new SuccessResult("Onaylandı.");
	}

	/*
	@Override
	public Result updateIsConfirm(boolean isConfirm, int id) 
	{
		this.jobAdvertDao.updateIsConfirm(isConfirm, id);
		return new SuccessResult("İş ilanı onaylandı");
	}
	

	@Override
	public Result updateIsActive(boolean isActive, int userId, int id)
	{
		this.jobAdvertDao.updateIsActive(userId, id, isActive);
		return new SuccessResult("İş ilanı aktiflik durumu güncellendi");
	}
	*/
}
