package hrms.project.hrms.dataAccess.abstracts;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import hrms.project.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
	Job findByjobTitleEquals(String jobTitle);
}
