package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;
public interface EmployerService {
	
	Result add(Employer employer);
	Result update(Employer employer);
	Result delete(int id);
	DataResult<Employer> getByWebsite(String website);
	DataResult<Employer> getById(int id);
	DataResult<List<Employer>> getAll();
	
}
