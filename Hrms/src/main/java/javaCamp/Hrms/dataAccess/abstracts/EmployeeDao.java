package javaCamp.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaCamp.Hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
