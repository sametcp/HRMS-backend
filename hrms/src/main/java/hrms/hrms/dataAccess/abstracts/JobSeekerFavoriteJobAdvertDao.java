package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobSeekerFavoriteJobAdverts;

public interface JobSeekerFavoriteJobAdvertDao extends JpaRepository<JobSeekerFavoriteJobAdverts, Integer> {

	
	List<JobSeekerFavoriteJobAdverts> getAllByJobseeker_Id(int jobseekerId);
	
}
