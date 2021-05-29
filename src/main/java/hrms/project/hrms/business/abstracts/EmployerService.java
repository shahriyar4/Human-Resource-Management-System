package hrms.project.hrms.business.abstracts;

import java.util.List;

import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
