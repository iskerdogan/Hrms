package javaCamp.Hrms.business.abstracts;

import java.util.List;

import javaCamp.Hrms.core.utilities.result.DataResult;
import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
	boolean isPositionName(JobPosition jobPosition);
	 
}
