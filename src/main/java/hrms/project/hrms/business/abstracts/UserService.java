package hrms.project.hrms.business.abstracts;

import java.util.List;

import hrms.project.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
}
