package hrms.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.ImageForCV;

public interface ImageForCVService {
	
	Result add(int id, ImageForCV imageForCV, MultipartFile imageFile);
	Result update(ImageForCV imageForCV);
	Result delete(int id);
	
	DataResult<ImageForCV> getImageForCVById(int id);	
	DataResult<List<ImageForCV>> getAll();
	DataResult<ImageForCV> getByJobseekerId(int id);
	
}
