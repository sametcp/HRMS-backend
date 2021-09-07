package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.ImageForCV;

public interface ImageForCVDao extends JpaRepository<ImageForCV, Integer>{
	
	ImageForCV getImageForCVById(int id);
	ImageForCV getByJobseeker_id(int id);
	// normalde getAllByJobseeker_id. burada onetoone ilişkisi olduğu için 1 jobseeker'da 1 image var zaten.
	
}
