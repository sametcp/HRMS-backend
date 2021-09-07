package hrms.hrms.business.abstracts;

import java.util.List;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employee;
import hrms.hrms.entities.concretes.Employer;

public interface EmployeeService {
	
	DataResult<List<Employee>> getAll();
	Result add(Employee employee);
	Result update(Employee employee);
	DataResult<Employee> getById(int id);
	
}
