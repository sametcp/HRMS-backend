package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForeignLanguageForCVDto {
	
	private int id;
	
	private int jobseekerId;
	
	private String language; 
	
	private String level;
	
}
