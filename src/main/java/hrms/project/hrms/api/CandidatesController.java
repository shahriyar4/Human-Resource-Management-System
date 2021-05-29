package hrms.project.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.project.hrms.business.abstracts.CandidatesService;
import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.entities.concretes.Candidates;

@RequestMapping("/api/candidates")
@RestController
public class CandidatesController {

	private CandidatesService candidatesService;

	@Autowired
	public CandidatesController(CandidatesService candidatesService) {
		super();
		this.candidatesService = candidatesService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Candidates>> getAll() {

		return this.candidatesService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Candidates candidates) {

		return this.candidatesService.add(candidates);
	}

}
