package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import hrms.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	@Query("From JobAdvert where isOpen = true Order By publishedDate Desc")
	List<JobAdvert> findAllByOrderByPublishedDateDesc();
	
	@Query("From JobAdvert where isOpen = true Order By publishedDate Asc")
	List<JobAdvert> findAllByOrderByPublishedDateAsc();
	
	
	
	JobAdvert getById(int id);
	
	Page<JobAdvert> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, Pageable pageable);
	List<JobAdvert> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	
	List<JobAdvert> getByEmployer_Id(int id);
	
	List<JobAdvert> getByIsConfirm(boolean isConfirm);
	List<JobAdvert> getByIsActive(boolean isActive);
	
	
	
}
