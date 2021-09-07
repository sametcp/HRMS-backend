package hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="verification_codes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationCodes {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	

	public VerificationCodes(int id,  String code, boolean isConfirmed) {
		this.id = id;
		this.code = code;
		this.isConfirmed = isConfirmed;
	}
}
