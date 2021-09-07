package hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name= "id")
	private int id;
	
	@Email
	@Column(name= "email")
	private String email;
	
	@Column(name= "password")
	private String password;
	
	@JsonIgnore // bu kullanıcı nesnemi, istemciye göndermek istemiyorum.
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@JsonIgnore
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;
	
	@Column(name= "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@Column(name= "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;
	
	
}
