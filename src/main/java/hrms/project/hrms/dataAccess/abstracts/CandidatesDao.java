package hrms.project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.project.hrms.entities.concretes.Candidates;

public interface CandidatesDao extends JpaRepository<Candidates, Integer> {
	Candidates findByEmailEquals(String email);

	Candidates findByNationaltyIdEquals(String nationaltyId);
}
