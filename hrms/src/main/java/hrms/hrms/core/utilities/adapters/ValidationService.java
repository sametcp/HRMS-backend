package hrms.hrms.core.utilities.adapters;

public interface ValidationService {
	
	// dışarıdan aldığım mernis sınıfına bağımlı olmamak için genel adıyla validationservice isimli interface'e ihtiyacım var
	boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth);
	
}
