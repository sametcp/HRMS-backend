package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertDto;
import hrms.hrms.entities.dtos.JobAdvertFilter;

public interface JobAdvertService {
	
	Result add(JobAdvertDto jobAdvertDto);
	Result update(JobAdvert jobAdvert);
	Result delete(int id);
	
	Result updateIsConfirm(boolean isConfirm, int id);
	Result updateIsActive(boolean isActive, int id);
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize);
	//DataResult<List<JobAdvert>> getAllOpenJobAdvertList();
	
	DataResult<JobAdvert> findById(int id);
	DataResult<List<JobAdvert>> getByEmployer_Id(int id);
	DataResult<List<JobAdvert>> findAllByOrderByPublishedDateDesc();
	DataResult<List<JobAdvert>> findAllByOrderByPublishedDateAsc();
	//DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);
	
	DataResult<List<JobAdvert>> getByIsConfirm(boolean isConfirm);
	DataResult<List<JobAdvert>> getByIsActive(boolean isActive);
	DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	
	DataResult<List<JobAdvert>> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, int pageNo, int pageSize);
	DataResult<List<JobAdvert>> sortByCreatedDate();
	
	DataResult<List<JobAdvert>> getByFilter(JobAdvertFilter jobAdvertFilter, int pageNo, int pageSize);
	
	
}
