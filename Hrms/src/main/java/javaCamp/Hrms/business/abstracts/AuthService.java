package javaCamp.Hrms.business.abstracts;

import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.entities.concretes.Employee;
import javaCamp.Hrms.entities.concretes.Employers;

public interface AuthService {
	Result registerEmployer(Employers employers);
	Result registerCandidate(Employee employee);
}
