package javaCamp.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.Hrms.business.abstracts.EmployersService;
import javaCamp.Hrms.core.utilities.result.DataResult;
import javaCamp.Hrms.entities.concretes.Employers;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	private EmployersService employersService;

	@Autowired
	public EmployersController(EmployersService employersService) {
		super();
		this.employersService = employersService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employers>> getAll(){
		return this.employersService.getall();
	}
}
