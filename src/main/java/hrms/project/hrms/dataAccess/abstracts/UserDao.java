package hrms.project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.project.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public List<User> findByEmail(String email);
}
