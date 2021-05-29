package hrms.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.project.hrms.business.abstracts.CandidatesService;
import hrms.project.hrms.core.adapters.abstracts.EmailValidationService;
import hrms.project.hrms.core.adapters.abstracts.FakeMernisService;
import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.ErrorResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.core.utilities.SuccesDataResult;
import hrms.project.hrms.core.utilities.SuccesResult;
import hrms.project.hrms.dataAccess.abstracts.CandidatesDao;
import hrms.project.hrms.entities.concretes.Candidates;

@Service
public class CandidateManager implements CandidatesService {

	private CandidatesDao candidatesDao;

	private FakeMernisService fakeMernisService;

	private EmailValidationService emailValidationService;

	@Autowired
	public CandidateManager(CandidatesDao candidatesDao, FakeMernisService fakeMernisService,
			EmailValidationService emailValidationService) {
		super();
		this.candidatesDao = candidatesDao;
		this.fakeMernisService = fakeMernisService;
		this.emailValidationService = emailValidationService;
	}

	@Override
	public DataResult<List<Candidates>> getAll() {

		return new SuccesDataResult<List<Candidates>>(this.candidatesDao.findAll(), "Data Listlendi");
	}

	@Override
	public Result add(Candidates candidates) {

		if (candidatesDao.findByEmailEquals(candidates.getEMail()) != null

				|| candidatesDao.findByNationaltyIdEquals(candidates.getNationallyId()) != null

		) {

			return new ErrorResult("Istifadəçi qeydiyyatdan keçmədi");
		}

		if (!this.fakeMernisService.checkUser(candidates.getNationallyId(), candidates.getFirstName(),

				candidates.getLastName(), candidates.getBirthDay())) {

			return new ErrorResult("İstifadəçi qeydiyyatdan keçə bilmədi ");

		}

		if (candidates.getPassword().isEmpty()) {

			return new ErrorResult("Şifrə boş ola bilməz  ");

		} else if (!emailValidationService.isValidEmail(candidates.getEMail())

		) {
			return new ErrorResult("Email dogru deyil");

		} else if (!emailValidationService.isValidEmailOnClick(candidates.getEMail())

		) {

			return new ErrorResult("Emaile gonderilen dogrulama   linkine tiklayin ");

		} else {

			this.candidatesDao.save(candidates);

			return new SuccesResult("Istifadeci ugurla qeydiyyatdan kecdi ");
		}

	}

}
