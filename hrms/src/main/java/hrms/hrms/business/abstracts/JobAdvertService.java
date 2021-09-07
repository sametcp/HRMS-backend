package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	
	Result add(JobAdvertDto jobAdvertDto);
	Result update(JobAdvert jobAdvert);
	Result updateIsConfirm(boolean isConfirm, int id);
	Result delete(int id);
	Result changeOpenToClose(int id);
	Result changeCloseToOpen(int id);
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();
	
	DataResult<JobAdvert> findById(int id);
	DataResult<List<JobAdvert>> findAllByOrderByPublishedDateDesc();
	DataResult<List<JobAdvert>> findAllByOrderByPublishedDateAsc();
	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);
	
	DataResult<List<JobAdvert>> getByIsConfirm(boolean isConfirm);
	DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	
	//Result updateIsConfirm(boolean isConfirm, int id);
	//Result updateIsActive(boolean isActive, int userId, int id);
	
}
