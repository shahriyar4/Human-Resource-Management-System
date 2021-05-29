package hrms.project.hrms.business.abstracts;

import java.util.List;

import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.entities.concretes.Candidates;

public interface CandidatesService {
	DataResult<List<Candidates>> getAll();

	Result add(Candidates candidates);
}
