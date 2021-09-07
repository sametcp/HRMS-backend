package hrms.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobseekers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerFavoriteJobAdverts"})
public class Jobseeker extends User{
	 
	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name= "national_id")
	private String nationalId;
	
	@Column(name= "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
	
	// mapped edilen jobseeker tanımlaması, class adına denk gelir. bu class.
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<SchoolForCV> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<ExperienceForCV> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<ForeignLanguageForCV> languages;
	
	@JsonIgnore  // JSON verisinde gözükmesi istenmeyen anahtarlar özel olarak belirtmek istenirse kullanılır.
	@OneToMany(mappedBy = "jobseeker")
	private List<CoverLetterForCV> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<ProgrammingSkillForCV> programingSkills;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<LinkForCV> links;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jobseeker")
	private ImageForCV image;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<JobSeekerFavoriteJobAdverts> jobSeekerFavoriteJobAdverts;
	
	// @JsonIgnore koyuyorum ki iş arayan kendini eklerken sadece kişisel bilgilerini ekleyebilsin.
	// diğerlerini başka türlü ekleyecek. (Database'e başka türlü gelecek)
}
