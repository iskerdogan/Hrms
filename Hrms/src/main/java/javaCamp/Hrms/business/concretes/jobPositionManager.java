package javaCamp.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.Hrms.business.abstracts.JobPositionService;
import javaCamp.Hrms.dataAccess.abstracts.JobPositionDao;
import javaCamp.Hrms.entities.concretes.JobPosition;

@Service
public class jobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public jobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionDao.findAll();
	}

}
