package hrms.project.hrms.core.adapters.concretes;

import hrms.project.hrms.core.adapters.abstracts.EmployeeValidationService;
import hrms.project.hrms.entities.concretes.Employer;

public class EmployerValidationManager implements EmployeeValidationService {

	@Override
	public boolean isValidatedEmployee(Employer employer) {
		System.out.println(employer.getCompanyName() + " isimli şirkət sistem işçiləri tərəfindən onaylanıb.");
		return true;
	}

}
