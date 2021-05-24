package hrms.project.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.project.hrms.business.abstracts.JobTitleService;
import hrms.project.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitle")
public class JobTitlesController {

	@Autowired
	private JobTitleService JobTitleService;

	public JobTitlesController(hrms.project.hrms.business.abstracts.JobTitleService jobTitleService) {
		super();
		JobTitleService = jobTitleService;
	}

	@GetMapping("/getall")
	public List<JobTitle> getAll() {
		return this.JobTitleService.getAll();

	}

}
