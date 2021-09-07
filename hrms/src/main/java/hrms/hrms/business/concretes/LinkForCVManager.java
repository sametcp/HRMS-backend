package hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms.business.abstracts.LinkForCVService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.core.utilities.results.SuccessResult;
import hrms.hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.hrms.dataAccess.abstracts.LinkForCVDao;
import hrms.hrms.entities.concretes.LinkForCV;
import hrms.hrms.entities.dtos.LinkForCVDto;

@Service
public class LinkForCVManager implements LinkForCVService{
	
	private LinkForCVDao linkForCVDao;
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public LinkForCVManager(LinkForCVDao linkForCVDao, JobSeekerDao jobSeekerDao)
	{
		super();
		this.linkForCVDao = linkForCVDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(LinkForCVDto linkForCVDto) 
	{
		LinkForCV linkForCV = new LinkForCV();

		linkForCV.setJobseeker(this.jobSeekerDao.getJobseekerById(linkForCVDto.getJobseekerId()));
		linkForCV.setLinkedinUrl(linkForCVDto.getLinkedinUrl());
		linkForCV.setGithubUrl(linkForCVDto.getGithubUrl());

		this.linkForCVDao.save(linkForCV);
		return new SuccessResult("Bilgiler Eklendi.");
	}


	@Override
	public Result update(LinkForCVDto linkForCVDto)
	{
		LinkForCV linkForCVUpdate = this.linkForCVDao.getById(linkForCVDto.getId());
		// bu şekilde id'ye müdahele etmiyoruz. sadece id hakkında istenen güncellemeleri yapmayı sağlıyoruz.
		// yukarıda id'de müdahele ediyorduk(ekliyoruz çünkü)

		linkForCVUpdate.setLinkedinUrl(linkForCVDto.getLinkedinUrl());
		linkForCVUpdate.setGithubUrl(linkForCVDto.getGithubUrl());
		
		this.linkForCVDao.save(linkForCVUpdate);
		return new SuccessResult("Bilgiler Güncellendi.");
	}

	@Override
	public Result delete(int id) 
	{
		this.linkForCVDao.deleteById(id);
		return new SuccessResult("Link has been deleted.");
	}


	@Override
	public DataResult<List<LinkForCV>> getAll() 
	{
		return new SuccessDataResult<List<LinkForCV>>(this.linkForCVDao.findAll());
	}

	@Override
	public DataResult<List<LinkForCV>> getAllByJobseekerId(int id) 
	{
		return new SuccessDataResult<List<LinkForCV>>(this.linkForCVDao.getAllByJobseeker_id(id));
	}

	@Override
	public DataResult<LinkForCV> getLinkForCVById(int id) 
	{
		return new SuccessDataResult<LinkForCV>(this.linkForCVDao.getById(id));
	}
	
}
