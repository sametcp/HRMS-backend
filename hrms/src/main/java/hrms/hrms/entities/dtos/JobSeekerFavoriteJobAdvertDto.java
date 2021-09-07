package hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerFavoriteJobAdvertDto {
	
	private int id;
	private int jobseekerId;
	private int jobAdvertId;
	
}
