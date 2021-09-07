package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ProgrammingSkillForCV;
import hrms.hrms.entities.dtos.ProgrammingSkillForCVDto;

public interface ProgrammingSkillForCVService {
	
	Result add(ProgrammingSkillForCVDto programmingSkillForCVDto);
	Result update(ProgrammingSkillForCVDto programmingSkillForCVDto);
	Result delete(int id);
	
	DataResult<ProgrammingSkillForCV> getProgrammingSkillForCVById(int id);	
	DataResult<List<ProgrammingSkillForCV>> getAll();
	DataResult<List<ProgrammingSkillForCV>> getAllByJobseekerId(int id);
	
}
