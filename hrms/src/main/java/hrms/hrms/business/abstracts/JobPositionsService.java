package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.JobPositions;

public interface JobPositionsService {
	
	Result add(JobPositions jobPositions);
	
	DataResult<List<JobPositions>> getAll();
	DataResult<JobPositions> getByJobTitle(String title);
}
