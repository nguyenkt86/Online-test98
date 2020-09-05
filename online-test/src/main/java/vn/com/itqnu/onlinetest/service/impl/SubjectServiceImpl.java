package vn.com.itqnu.onlinetest.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Subject;
import vn.com.itqnu.onlinetest.model.SubjectModel;
import vn.com.itqnu.onlinetest.repository.SubjectRepository;
import vn.com.itqnu.onlinetest.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	private SubjectRepository subjectRepository;

	public SubjectServiceImpl(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	@Override
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject getSubjectById(Long idSubject) {
		Optional<Subject> optional = subjectRepository.findById(idSubject);
		if (optional != null && optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Subject createSubject(SubjectModel subjectModel) {
		if (subjectModel.getSubjectName()== null || subjectModel.getSubjectName().trim().length() == 0) {
			throw new RuntimeException("Answer name is required!");
		}

		Subject subject = new Subject();
		subject.setSubjectName(subjectModel.getSubjectName());

		subject.setCreatedBy("ADMIN");
		subject.setCreatedDate(new Date());
		subject.setModifiedBy("ADMIN");
		subject.setModifiedDate(new Date());

		subjectRepository.save(subject);
		
		return subject;
	}

	@Override
	public Subject updateSubject(SubjectModel subjectModel) {
		Subject subject = getSubjectById(subjectModel.getId());
		if( subject == null) {
			throw new RuntimeException("Subject does not exits!");
		}
		subjectModel.setSubjectName(subjectModel.getSubjectName());
		
		subjectRepository.save(subject);
		
		return subject;
	}

	@Override
	public void deleteSubject(Long idSubject) {
			Subject subject = getSubjectById(idSubject);
			
			if( subject == null) {
				throw new RuntimeException("Subject does not exits!");
			}
			subjectRepository.delete(subject);
	}

}
