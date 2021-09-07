package hrms.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertDto {

	private LocalDate deadline;

	private String statement;

	private int salaryMin;

	private int salaryMax;
	
	private int workTypeId;

	private int workHourId;

	private int jobPositionId;

	private int employerId;
	
	private int cityId;
	
	private int openPositionCount;
	
}
