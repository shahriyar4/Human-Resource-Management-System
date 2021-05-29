package hrms.project.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.project.hrms.business.abstracts.EmployerService;
import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll() {

		return this.employerService.getAll();
	}

	@PostMapping("/add")
	
	
	public Result add(@RequestBody Employer employer) {
		
		return this.employerService.add(employer);
	}
}
