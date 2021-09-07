package hrms.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "jobadverts")
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)

public class JobAdvert {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	 
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@JsonIgnore // bu kullanıcı nesnemi, istemciye göndermek istemiyorum.
	@Column(name= "is_active")
	private boolean isActive = true;
	
	
	@Column(name = "statement")  // açıklama
	private String statement;
	
	@Column(name = "salary_min")  // min maaş
	private int salaryMin;
	
	@Column(name = "salary_max")  // max maaş
	private int salaryMax;
	
	@Column(name = "open_position_count")  // açık pozisyon adedi
	private int openPositionCount;
	
	@Column(name = "deadline")  // son başvuru tarihi
	private LocalDate deadline;
	
	@Column(name = "published_date")  // yayınlanma tarihi
	private LocalDate publishedDate;
	
	@Column(name = "is_open")
	private boolean isOpen;

	@ManyToOne  
	@JoinColumn(name = "job_position_id") // iş yerimde pozisyon id'si olacak
	private JobPositions jobPositions;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id", referencedColumnName = "user_id")  // iş yerimde çalışanımın id'si olacak.
	private Employer employer;
	
	@ManyToOne () // bir şehirde 2 iş yeri olduğunu varsayarsak şehir tekrar edicek. o yüzden many.
	@JoinColumn(name = "city_id")  // iş ilanımda şehrimin id'si olacak.
	private City city;
	
	@ManyToOne ()
	@JoinColumn(name = "work_type_id")
	private WorkType workType;
	
	@ManyToOne ()
	@JoinColumn(name = "work_hour_id")
	private WorkHour workHour;
	
	@Column(name = "is_confirm")
	private boolean isConfirm;
	
}
