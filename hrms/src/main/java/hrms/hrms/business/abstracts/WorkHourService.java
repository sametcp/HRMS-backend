package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.WorkHour;

public interface WorkHourService {
	
	Result add(WorkHour workHour);
	
	DataResult<List<WorkHour>> getAll();
	
}
