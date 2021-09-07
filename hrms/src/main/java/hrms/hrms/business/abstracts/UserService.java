package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	DataResult<User> getUserByEmail(String email);
	Result add(User user);
}
