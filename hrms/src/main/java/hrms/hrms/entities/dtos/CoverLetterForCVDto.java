package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetterForCVDto {
	
	private int id;
	private int jobseekerId;
	private String content;
	
}
