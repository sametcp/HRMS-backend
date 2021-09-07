package hrms.hrms.entities.concretes;

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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_programming_skills")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProgrammingSkillForCV {
	
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
	
	@Column(name = "skill_name")
	private String skillName;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private Jobseeker jobseeker;
	
}
