package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkForCVDto {
	
	private int id;

	private int jobseekerId;

	private String githubUrl;

	private String linkedinUrl;
}
