package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.WorkHourService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.WorkHourDao;
import hrms.hrms.entities.concretes.WorkHour;

@Service
public class WorkHourManager implements WorkHourService{

	private WorkHourDao workHourDao;
	
	@Autowired
	public WorkHourManager(WorkHourDao workHourDao)
	{
		super();
		this.workHourDao = workHourDao;
	}

	@Override
	public Result add(WorkHour workHour) 
	{
		this.workHourDao.save(workHour);
		return new SuccessResult("Work hour has been added.");
	}

	@Override
	public DataResult<List<WorkHour>> getAll() 
	
	{
		return new SuccessDataResult<List<WorkHour>>
		(this.workHourDao.findAll(),"Data listelendi.");
	}
	
	
	
}
