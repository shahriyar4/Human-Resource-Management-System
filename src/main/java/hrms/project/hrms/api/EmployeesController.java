package hrms.project.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.project.hrms.business.abstracts.EmployeeService;
import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll() {

		return this.employeeService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {

		return this.employeeService.add(employee);
	}

}
