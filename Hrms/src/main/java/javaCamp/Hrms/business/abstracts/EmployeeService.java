package javaCamp.Hrms.business.abstracts;

import java.util.List;

import javaCamp.Hrms.core.utilities.result.DataResult;
import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getall();
	Result add(Employee employee);
	boolean checkNull(Employee employee);
	boolean isEmailAndIdentityName(Employee employee);
	
}
