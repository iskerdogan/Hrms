package javaCamp.Hrms.core.utilities;

import javaCamp.Hrms.core.utilities.adapters.ValidationService;
import javaCamp.Hrms.entities.concretes.Employee;

public class FakeMernisService implements ValidationService{

	@Override
	public boolean mernisValidate(Employee employee) {
		return true;
	}

}
