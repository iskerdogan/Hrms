package javaCamp.Hrms.business.abstracts;

import java.util.List;

import javaCamp.Hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
