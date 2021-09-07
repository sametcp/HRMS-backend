package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ForeignLanguageForCV;
import hrms.hrms.entities.dtos.ForeignLanguageForCVDto;

public interface ForeignLanguageForCVService {
	
	Result add(ForeignLanguageForCVDto foreignLanguageForCVDto);
	Result update(ForeignLanguageForCVDto foreignLanguageForCVDto);
	Result delete(int id);
	
	DataResult<ForeignLanguageForCV> getForeignLanguageForCVById(int id);	
	DataResult<List<ForeignLanguageForCV>> getAll();
	DataResult<List<ForeignLanguageForCV>> getAllByJobseekerId(int id);
	
}
