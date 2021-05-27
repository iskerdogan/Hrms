package javaCamp.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaCamp.Hrms.entities.concretes.Employers;

public interface EmployersDao extends JpaRepository<Employers, Integer>{

}
