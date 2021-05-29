package hrms.project.hrms.core.adapters.concretes;

import java.util.regex.Pattern;

import hrms.project.hrms.core.adapters.abstracts.EmailValidationService;

public class EmailValidationManager implements EmailValidationService {

	@Override
	public boolean isValidEmail(String email) {

		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
				Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}

	@Override
	public boolean isValidEmailOnClick(String email) {
		System.out.println("Doğrulama uğurlu " + email);
		return true;
	}

}
