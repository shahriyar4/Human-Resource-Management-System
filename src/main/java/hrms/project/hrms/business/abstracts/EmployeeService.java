package hrms.project.hrms.business.abstracts;

import java.util.List;

import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();

	Result add(Employee employee);
}
