package hrms.project.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.project.hrms.business.abstracts.UserService;
import hrms.project.hrms.dataAccess.abstracts.UserDao;
import hrms.project.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {

		return this.userDao.findAll();
	}

}
