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

@Entity
@Data
@Table(name = "cv_experiences")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ExperienceForCV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@JsonIgnore
	@Column(name= "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@JsonIgnore
	@Column(name= "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;
	
	
	@Column(name = "started_date")
	private LocalDate startDate;
	
	@Column(name = "end_date", nullable = true)
	private LocalDate endDate;
	
	@Column(name = "workplace")
	private String workplace;
	
	@Column(name = "position")
	private String position;
	
	@JsonIgnore
	@ManyToOne()  // experience birden çok olabilir. kendi class'ında o yüzden many.
	@JoinColumn(name = "jobseeker_id")  // one old. tek bir değişken tanımlamak yeterli jobseeker için.
	private Jobseeker jobseeker; // jobseeker'ın birden fazla experience'ı olabileceğinden orda list.
	
}
