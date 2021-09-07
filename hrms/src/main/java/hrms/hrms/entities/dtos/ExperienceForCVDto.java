package hrms.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceForCVDto {
	
	private int id;
	
	private int jobseekerId;
	
	private String workplace;
	
	private String position;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	
}
