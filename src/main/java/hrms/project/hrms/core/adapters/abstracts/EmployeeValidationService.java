package hrms.project.hrms.core.adapters.abstracts;


import hrms.project.hrms.entities.concretes.Employer;

public interface EmployeeValidationService {

	boolean isValidatedEmployee(Employer employer);

}
