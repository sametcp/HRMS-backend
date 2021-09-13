package hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.hrms.entities.concretes.JobAdvert;
import hrms.hrms.entities.dtos.JobAdvertFilter;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	
	JobAdvert getById(int id);
	
	Page<JobAdvert> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, Pageable pageable);
	List<JobAdvert> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	
	List<JobAdvert> getByEmployer_Id(int id);
	
	List<JobAdvert> getByIsConfirm(boolean isConfirm);
	List<JobAdvert> getByIsActive(boolean isActive);
	
	
	@Query("From JobAdvert where isOpen = true Order By publishedDate Desc")
	List<JobAdvert> findAllByOrderByPublishedDateDesc();
	
	@Query("From JobAdvert where isOpen = true Order By publishedDate Asc")
	List<JobAdvert> findAllByOrderByPublishedDateAsc();
	
	@Query("Select j from hrms.hrms.entities.concretes.JobAdvert j where "
			+ "((:#{#filter.jobPositionId}) IS NULL OR j.jobPositions.id IN (:#{#filter.jobPositionId})) "
			+ "and ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId})) "
			+ "and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId})) "
			+ "and ((:#{#filter.workHourId}) IS NULL OR j.workHour.id IN (:#{#filter.workHourId})) "
			+ "and j.isActive = true " + "and j.isConfirm = true")
	Page<JobAdvert> getByFilter(@Param("filter") JobAdvertFilter jobAdvertFilter, Pageable pageable);
	
}
