package javaCamp.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaCamp.Hrms.business.abstracts.EmployeeService;
import javaCamp.Hrms.core.utilities.result.DataResult;
import javaCamp.Hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getall();
	}
	
	/*@PostMapping("/register")
	public Result register(@RequestBody Employee employee){
		return this.employeeService.register(employee);
	}*/
}
