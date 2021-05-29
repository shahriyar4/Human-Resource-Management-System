package hrms.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.project.hrms.business.abstracts.EmployerService;
import hrms.project.hrms.core.adapters.abstracts.EmailValidationService;
import hrms.project.hrms.core.adapters.abstracts.EmployeeValidationService;
import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.ErrorResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.core.utilities.SuccesDataResult;
import hrms.project.hrms.core.utilities.SuccesResult;
import hrms.project.hrms.dataAccess.abstracts.EmployerDao;
import hrms.project.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	private EmailValidationService emailValidationService;

	private EmployeeValidationService employeeValidationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailValidationService emailValidationService,
			EmployeeValidationService employeeValidationService) {
		super();
		this.employerDao = employerDao;
		this.emailValidationService = emailValidationService;
		this.employeeValidationService = employeeValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccesDataResult<List<Employer>>(this.employerDao.findAll(), "Şirkətlər sistemə əlavə edildi ");
	}

	@Override
	public Result add(Employer employer) {

		if (employerDao.findByEmailEquals(

				employer.getEMail()) != null || employerDao.findByWebSiteEquals(employer.getWebAddress()) != null) {

			return new ErrorResult("Şirkət sistemə əlavə edilə bilmədi");

		}
		if (employer.getPassword().isEmpty()) {

			return new ErrorResult("Şifrə boş ola bilməz ");
		}

		if (eMailequalsWebSite(employer) != null) {

			return new ErrorResult("E mail ilə web domaininiz eyni olmalidir");
		}

		if (emailValidationService.isValidEmail(employer.getEMail())) {

			return new ErrorResult("Email  səf girilib ");
		} else if (employeeValidationService.isValidatedEmployee(employer)) {
			return new ErrorResult("Hesabinizi e mailinizdən doğrulayın ");
		} else {

			this.employerDao.save(employer);

			return new SuccesResult("Uğurlu qeydiyyat!");
		}

	}

	private Result eMailequalsWebSite(Employer employer) {
		String email = employer.getEMail();
		String webSite = employer.getWebAddress();
		String[] emailSplit = email.split("@");
		String[] webSiteSplit = webSite.split("www.");
		if (!emailSplit[1].equals(webSiteSplit[1])) {
			return new ErrorResult("E mail ilə web domaininiz eyni olmalidir");
		}
		return null;
	}
}
