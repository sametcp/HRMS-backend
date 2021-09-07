package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobSeekerFavoriteJobAdverts;
import hrms.hrms.entities.dtos.JobSeekerFavoriteJobAdvertDto;

public interface JobSeekerFavoriteJobAdvertService {
	
	Result add(JobSeekerFavoriteJobAdvertDto jobSeekerFavoriteJobAdvertDto);

	Result delete(int id);

	DataResult<List<JobSeekerFavoriteJobAdverts>> getByJobseekerId(int id);
	
}
