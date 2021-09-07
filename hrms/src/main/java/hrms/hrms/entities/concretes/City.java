package hrms.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
@EqualsAndHashCode(callSuper=false)

public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@JsonIgnore  // bu kullanıcı nesnemi, istemciye göndermek istemiyorum.
	@Column(name= "created_date")
	private LocalDate createdDate;
	
	@JsonIgnore
	@Column(name= "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@JsonIgnore
	@Column(name= "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;
	
	@OneToMany(mappedBy = "city")  // 1 şehirde birden fazla iş yeri olabilir
	private List<JobAdvert> jobAdverts;
	
	public City(String name, List<JobAdvert> jobAdverts) {
		super();
		this.name = name;
		this.jobAdverts = jobAdverts;
	}
	
}
