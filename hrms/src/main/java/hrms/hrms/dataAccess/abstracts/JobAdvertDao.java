package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	@Query("From JobAdvert where isOpen = true")
	List<JobAdvert> getAllOpenJobAdvertList();
	
	@Query("From JobAdvert where isOpen = true Order By publishedDate Desc")
	List<JobAdvert> findAllByOrderByPublishedDateDesc();
	
	@Query("From JobAdvert where isOpen = true Order By publishedDate Asc")
	List<JobAdvert> findAllByOrderByPublishedDateAsc();
	
	@Query("From JobAdvert where isOpen = true and employer_id =:id")
	List<JobAdvert> getAllOpenJobAdvertByEmployer(int id);
	
	
	JobAdvert getById(int id);
	
	List<JobAdvert> getByIsConfirm(boolean isConfirm);
	
	List<JobAdvert> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	
	
	
}
