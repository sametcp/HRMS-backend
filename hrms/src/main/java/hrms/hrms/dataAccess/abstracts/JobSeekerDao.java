package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.Jobseeker;

public interface JobSeekerDao extends JpaRepository<Jobseeker, Integer>{
	
	Jobseeker findJobseekerByNationalId(String nationalId);
	Jobseeker getJobseekerById(int id);
}
