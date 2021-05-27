package javaCamp.Hrms.business.abstracts;

import java.util.List;

import javaCamp.Hrms.core.utilities.result.DataResult;
import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.entities.concretes.Employers;

public interface EmployersService {
	DataResult<List<Employers>> getall();
	Result add(Employers employers);
	boolean checkNull(Employers employers);
	boolean isEmailAndIdentityName(Employers employers);
}
