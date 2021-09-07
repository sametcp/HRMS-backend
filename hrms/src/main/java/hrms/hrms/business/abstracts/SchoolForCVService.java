package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.SchoolForCV;
import hrms.hrms.entities.dtos.SchoolForCVDto;

public interface SchoolForCVService {
	
	Result add(SchoolForCVDto schoolForCVDto);
	Result update(SchoolForCVDto choolForCVDto);
	Result delete(int id);
	DataResult<List<SchoolForCV>> getAllSorted(int id); 
	
	DataResult<SchoolForCV> getById(int id);	
	DataResult<List<SchoolForCV>> getAll();
	DataResult<List<SchoolForCV>> getByJobseekerId(int id);
	
}
