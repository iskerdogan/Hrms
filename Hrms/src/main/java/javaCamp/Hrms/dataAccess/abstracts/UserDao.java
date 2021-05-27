package javaCamp.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaCamp.Hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
