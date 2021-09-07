package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.LinkForCV;
import hrms.hrms.entities.dtos.LinkForCVDto;

public interface LinkForCVService {
	
	Result add(LinkForCVDto linkForCVDto);
	Result update(LinkForCVDto linkForCVDto);
	Result delete(int id);
	
	DataResult<LinkForCV> getLinkForCVById(int id);	
	DataResult<List<LinkForCV>> getAll();
	DataResult<List<LinkForCV>> getAllByJobseekerId(int id);
	
}
