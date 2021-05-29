package hrms.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.project.hrms.business.abstracts.JobTitleService;
import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.ErrorResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.core.utilities.SuccesDataResult;
import hrms.project.hrms.core.utilities.SuccesResult;
import hrms.project.hrms.dataAccess.abstracts.JobTitleDao;
import hrms.project.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {

		return new SuccesDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "İşler listelendi.");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if (jobTitleDao.findByjobTitleEquals(jobTitle.getTitle()) != null) {
			return new ErrorResult("Bu iş dalı daha önce eklenmiştir." + " Ekleme başarısız");
		} else {
			this.jobTitleDao.save(jobTitle);
			return new SuccesResult("Başarıyla eklendi");
		}
	}
}
