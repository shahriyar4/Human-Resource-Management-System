package hrms.project.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "users_id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidates extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationally_id")
	private String nationallyId;

	@Column(name = "birth_of_date")
	private String birthDay;

	public Candidates(int id, String email, String password, String firstName, String lastName, String nationallyId,
			String birthDay) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationallyId = nationallyId;
		this.birthDay = birthDay;
	}

}
