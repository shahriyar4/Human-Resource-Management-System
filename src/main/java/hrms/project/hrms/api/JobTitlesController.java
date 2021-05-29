package hrms.project.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.project.hrms.business.abstracts.JobTitleService;
import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitle")
public class JobTitlesController {

	private JobTitleService JobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		JobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll() {
		return this.JobTitleService.getAll();

	}

	public Result add(@RequestBody JobTitle jobTitle) {
		return this.JobTitleService.add(jobTitle);

	}
}
