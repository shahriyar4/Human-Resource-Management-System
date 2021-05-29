package hrms.project.hrms.core.adapters.concretes;

import hrms.project.hrms.core.adapters.abstracts.FakeMernisService;

public class FakeMernisManager implements FakeMernisService {

	@Override
	public boolean checkUser(String nationallyId, String firstName, String lastName, String birthDay) {
		if (nationallyId.length() != 10) {
			System.out.println("Ş.V seriya nömrəsi 10 simvoldan az və yaxud böyükdür ");
			return false;
		}

		if (firstName.length() < 2 || lastName.length() < 2) {
			System.out.println("Ş.V seriya nömrəsi 10 simvoldan az və yaxud böyükdür ");
			return false;
		}
		if (birthDay.length() != 4) {
			System.out.println(" Zəhmət olmasa doğum tarixinizi yalnız il olaraq yazın! ");
			return false;
		} else {

			System.out.println("Ş.V doğrulaması uğurla başa çatdı ");

			return true;

		}

	}

}
