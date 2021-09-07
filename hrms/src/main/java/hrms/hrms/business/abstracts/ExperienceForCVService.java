package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ExperienceForCV;
import hrms.hrms.entities.dtos.ExperienceForCVDto;

public interface ExperienceForCVService {
	
	Result add(ExperienceForCVDto experienceForCVDto);
	Result update(ExperienceForCVDto experienceForCVDto);
	Result delete(int id);
	
	DataResult<ExperienceForCV> getById(int id);	
	DataResult<List<ExperienceForCV>> getAll();
	DataResult<List<ExperienceForCV>> getAllSorted(); 
	DataResult<List<ExperienceForCV>> getAllByJobseekerId(int id);
	
}
