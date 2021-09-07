package hrms.hrms.core.utilities.image;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorDataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService{
	
	private Cloudinary cloudinary;

	
	public ImageUploadManager() 
	{
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dwb0gqsun",
				"api_key", "372685754854993",
				"api_secret", "eDeYmbQV0G12veuRPto3oyJGCOY"));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) 
	{
		
		try 
		{
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>)cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();  // programcının asıl sorunun nerede meydana geldiğini anlamasına yardımcı olur.
			
		}
		return new ErrorDataResult<Map>();
	}
}
