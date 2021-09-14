package hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jobseeker_favorite_job_adverts")

public class JobSeekerFavoriteJobAdverts {
	
	 	@Id()
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @ManyToOne()
	    @JoinColumn(name = "jobseeker_id")
	    private Jobseeker jobseeker;

	    @OneToOne()
	    @JoinColumn(name = "job_advert_id")
	    private JobAdvert jobAdvert;
	
}
