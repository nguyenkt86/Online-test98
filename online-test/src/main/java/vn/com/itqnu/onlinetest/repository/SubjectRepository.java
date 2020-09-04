package vn.com.itqnu.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.onlinetest.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	Subject findBySubjectName(String subjectName);
}
