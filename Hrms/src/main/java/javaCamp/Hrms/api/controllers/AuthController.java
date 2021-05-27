package javaCamp.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.Hrms.business.abstracts.AuthService;
import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.entities.concretes.Employee;
import javaCamp.Hrms.entities.concretes.Employers;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployee")
	public Result registerEmployee(@RequestBody Employee employee) {
		return this.authService.registerCandidate(employee);
	}
	
	@PostMapping("/registerEmployers")
	public Result registerEmployers(@RequestBody Employers employers) {
		return this.authService.registerEmployer(employers);
	}
}
