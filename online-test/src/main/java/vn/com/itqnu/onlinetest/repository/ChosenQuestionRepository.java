package vn.com.itqnu.onlinetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.onlinetest.entity.ChosenQuestion;

@Repository
public interface ChosenQuestionRepository extends JpaRepository<ChosenQuestion, Long>{


	@Query(value = "SELECT new vn.com.itqnu.onlinetest.model.ChosenQuestion(q,s)"
			+ " FROM Question q JOIN Subject s ON q.subjectid = s.id "
			+ " WHERE s.id = ?1")
	List<ChosenQuestion> getListQuestionBySubject();
}