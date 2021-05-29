package hrms.project.hrms.core.adapters.abstracts;

public interface EmailValidationService {

	boolean isValidEmail(String email);
	
	boolean isValidEmailOnClick(String email);

}
