package javaCamp.Hrms.core.utilities.adapters;

import javaCamp.Hrms.core.utilities.FakeMernisService;
import javaCamp.Hrms.entities.concretes.Employee;

public class MernisServiceAdapter implements ValidationService{
	
	FakeMernisService fakeMernisService = new FakeMernisService();
	
	@Override
	public boolean mernisValidate(Employee employee) {
		FakeMernisService result = new FakeMernisService();
		return result.mernisValidate(employee);
	}

}
