package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.JobPositions;

public interface JobPositionsDao extends JpaRepository<JobPositions, Integer>{
	
	JobPositions getByJobTitle(String title);
	JobPositions getById(int id);
}
