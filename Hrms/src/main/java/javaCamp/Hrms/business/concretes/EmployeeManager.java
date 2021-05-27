package javaCamp.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.Hrms.business.abstracts.EmployeeService;
import javaCamp.Hrms.core.utilities.result.DataResult;
import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.core.utilities.result.SuccessDataResult;
import javaCamp.Hrms.core.utilities.result.SuccessResult;
import javaCamp.Hrms.dataAccess.abstracts.EmployeeDao;
import javaCamp.Hrms.entities.concretes.Employee;


@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	
	@Override
	public DataResult<List<Employee>> getall() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}
	
	@Override
	public Result add(Employee employee) {
			this.employeeDao.save(employee);
			return new SuccessResult();
	}
	
	@Override
	public boolean checkNull(Employee employee) {
		if (employee.getFirstName().isEmpty() || employee.getLastName().isEmpty() || employee.getIdentityNumber().isEmpty() || employee.getEmail().isEmpty() || employee.getPassword().isEmpty() || employee.getPasswordRepeat().isEmpty()) {
			return false;
		}else {
			return true;
		}	
	}
	
	@Override
	public boolean isEmailAndIdentityName(Employee employee) {
		boolean result = false;
		for (Employee position :this.getall().getData()) {
			if (position.getEmail().equals(employee.getEmail()) && position.getIdentityNumber().equals(employee.getIdentityNumber())) {
				result = false;
			}else {
				result = true;
			}
		}
		return result;
	}
	

}
