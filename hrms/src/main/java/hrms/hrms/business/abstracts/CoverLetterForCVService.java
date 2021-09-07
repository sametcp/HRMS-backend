package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.CoverLetterForCV;
import hrms.hrms.entities.dtos.CoverLetterForCVDto;

public interface CoverLetterForCVService {
	
	Result add(CoverLetterForCVDto coverLetterForCVDto);
	Result update(CoverLetterForCVDto coverLetterForCVDto);
	Result delete(int id);
	
	DataResult<List<CoverLetterForCV>> getAllByJobseekerId(int id);
	DataResult<CoverLetterForCV> getCoverLetterForCVById(int id);	
	DataResult<List<CoverLetterForCV>> getAll();
	
}
