package hrms.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.project.hrms.business.abstracts.EmployeeService;
import hrms.project.hrms.core.utilities.DataResult;
import hrms.project.hrms.core.utilities.Result;
import hrms.project.hrms.core.utilities.SuccesDataResult;
import hrms.project.hrms.core.utilities.SuccesResult;
import hrms.project.hrms.dataAccess.abstracts.EmployeeDao;
import hrms.project.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccesDataResult<List<Employee>>(this.employeeDao.findAll(), "İşçilər listləndi !");

	}

	@Override
	public Result add(Employee employee) {

		this.employeeDao.save(employee);
		return new SuccesResult("İşçilər qeydiyyata düşdü");
	}

}
