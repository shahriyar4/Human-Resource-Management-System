package hrms.project.hrms.business.abstracts;

import java.util.List;

import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();

	Result add(JobTitle jobTitle);

}
