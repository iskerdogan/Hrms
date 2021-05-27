package javaCamp.Hrms.business.concretes;

import org.springframework.stereotype.Service;

import javaCamp.Hrms.business.abstracts.AuthService;
import javaCamp.Hrms.business.abstracts.EmployeeService;
import javaCamp.Hrms.business.abstracts.EmployersService;
import javaCamp.Hrms.core.utilities.adapters.ValidationService;
import javaCamp.Hrms.core.utilities.result.ErrorResult;
import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.core.utilities.result.SuccessResult;
import javaCamp.Hrms.entities.concretes.Employee;
import javaCamp.Hrms.entities.concretes.Employers;

@Service
public class AuthManager implements AuthService{
	
	private ValidationService validationService;
	private EmployeeService employeeService;
	private EmployersService employersService;
	
	
	@Override
	public Result registerCandidate(Employee employee) {
		if (!employeeService.checkNull(employee)) {
			return new ErrorResult("Boş geçilemez alan");
		}else if (!checkIfRealPerson(employee)) {
			return new ErrorResult("Bu kişi resmi kayıtlarda yok.");
		}else if (!employeeService.isEmailAndIdentityName(employee)) {
			return new ErrorResult("Aynı e-posta veya kimlik numarasında kayıt var");
		}
		employeeService.add(employee);
		return new SuccessResult("İş arayan başarıyla eklendi");
	}
	
	@Override
	public Result registerEmployer(Employers employers) {
		if (!employersService.checkNull(employers)) {
			return new ErrorResult("Boş geçilemez alan");
		}else if (!checkIfEqualMailAndWebdomain(employers.getEmail(), employers.getWebAdress())) {
			return new ErrorResult("Mail adresi eşleşmiyor.");
		}else if (!employersService.isEmailAndIdentityName(employers)) {
			return new ErrorResult("Aynı e-postada kayıt var");
		}
		employersService.add(employers);
		return new SuccessResult("İş arayan başarıyla eklendi");
	}
	
	public boolean checkIfRealPerson(Employee employee) {
		
		if (validationService.mernisValidate(employee)) {
			
			return true;
		}
		
		return false;
	}

	
	public boolean checkIfEqualMailAndWebdomain(String email,String website) {
		
		String[] emailAry = email.split("@", 2);
		
		String domain = website.substring(4, website.length());
		
		if (emailAry[1].equals(domain)) {
			
			return true;
		}
		
		return false;
	}
	
}
