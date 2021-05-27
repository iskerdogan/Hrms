package javaCamp.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaCamp.Hrms.business.abstracts.JobPositionService;
import javaCamp.Hrms.core.utilities.result.DataResult;
import javaCamp.Hrms.core.utilities.result.ErrorResult;
import javaCamp.Hrms.core.utilities.result.Result;
import javaCamp.Hrms.core.utilities.result.SuccessDataResult;
import javaCamp.Hrms.core.utilities.result.SuccessResult;
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
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Pozisyonlar listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		boolean result=this.isPositionName(jobPosition);
		if (result) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Pozisyon eklendi");
		}else {
			return new ErrorResult("Aynı isimde Pozisyon eklendi");
		}
		
	}
	
	public boolean isPositionName(JobPosition jobPosition) {
		boolean result = false;
		for (JobPosition position :this.getAll().getData()) {
			if (position.getJobPosition().equals(jobPosition.getJobPosition())) {
				result = false;
			}else {
				result = true;
			}
		}
		return result;
	}


}
