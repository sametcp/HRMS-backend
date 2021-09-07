package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.WorkTypeService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.WorkTypeDao;
import hrms.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{

	private WorkTypeDao workTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao)
	{
		super();
		this.workTypeDao = workTypeDao;
	}

	@Override
	public Result add(WorkType workType) 
	{
		this.workTypeDao.save(workType);
		return new SuccessResult("Work type has been added.");
	}

	@Override
	public DataResult<List<WorkType>> getAll() 
	{
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll(),"Data listelendi.");
	}
	
	
	
}
