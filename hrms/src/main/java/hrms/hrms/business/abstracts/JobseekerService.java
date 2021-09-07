package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Jobseeker;
import hrms.hrms.entities.dtos.JobSeekerCVDto;

public interface JobseekerService {
	
	Result add(Jobseeker jobseeker);
	Result update(Jobseeker jobseeker);
	Result delete(int id);
	DataResult<Jobseeker> getJobseekerById(int id);
	
	DataResult<List<Jobseeker>> getAll();
	DataResult<Jobseeker> getJobseekerByNationalId(String nationalId);
	DataResult<JobSeekerCVDto> getJobseekerCVById(int id);
}
