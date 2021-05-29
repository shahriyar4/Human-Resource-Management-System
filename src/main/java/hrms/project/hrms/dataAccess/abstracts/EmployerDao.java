package hrms.project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.project.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer findByEmailEquals(String email);

	
	Employer findByWebSiteEquals(String webSite);
}
