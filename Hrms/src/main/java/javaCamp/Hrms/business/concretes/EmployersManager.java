package javaCamp.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.Hrms.business.abstracts.EmployersService;
import javaCamp.Hrms.core.utilities.result.DataResult;
import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.core.utilities.result.SuccessDataResult;
import javaCamp.Hrms.core.utilities.result.SuccessResult;
import javaCamp.Hrms.dataAccess.abstracts.EmployersDao;
import javaCamp.Hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployersService{
	private EmployersDao employersDao;

	@Autowired
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}

	@Override
	public DataResult<List<Employers>> getall() {
		return new SuccessDataResult<List<Employers>>(this.employersDao.findAll());
	}

	@Override
	public Result add(Employers employers) {
		this.employersDao.save(employers);
		return new SuccessResult();
	}

	@Override
	public boolean checkNull(Employers employers) {
		if (employers.getCompanyName().isEmpty() || employers.getWebAdress().isEmpty() || employers.getEmail().isEmpty() || employers.getPhoneNumber().isEmpty() || employers.getPassword().isEmpty() || employers.getPasswordRepeat().isEmpty()) {
			return false;
		}else {
			return true;
		}	
	}

	@Override
	public boolean isEmailAndIdentityName(Employers employers) {
		boolean result = false;
		for (Employers position :this.getall().getData()) {
			if (position.getEmail().equals(employers.getEmail())) {
				result = false;
			}else {
				result = true;
			}
		}
		return result;
	}
}
