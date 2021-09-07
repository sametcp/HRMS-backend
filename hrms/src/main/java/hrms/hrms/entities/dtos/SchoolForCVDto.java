package hrms.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolForCVDto {
	
	private int id;
	
	private int jobseekerId;
	
	private String schoolName;
	
	private String department;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
}
