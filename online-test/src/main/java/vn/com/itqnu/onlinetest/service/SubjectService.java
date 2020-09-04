package vn.com.itqnu.onlinetest.service;

import java.util.List;

import vn.com.itqnu.onlinetest.entity.Subject;
import vn.com.itqnu.onlinetest.model.SubjectModel;

public interface SubjectService {
	
	List<Subject> getAllSubject();

	Subject getSubjectById(Long idSubject);

	Subject createSubject(SubjectModel subjectModel);
	
	Subject updateSubject(SubjectModel subjectModel);

	void deleteSubject(Long idSubject);
}
