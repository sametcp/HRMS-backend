package hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrms.entities.concretes.VerificationCodes;

public interface VerificationCodeDao extends JpaRepository<VerificationCodes, Integer>{

}
