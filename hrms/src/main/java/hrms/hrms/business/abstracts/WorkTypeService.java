package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	
	Result add(WorkType workType);
	
	DataResult <List<WorkType>> getAll();
	
}
