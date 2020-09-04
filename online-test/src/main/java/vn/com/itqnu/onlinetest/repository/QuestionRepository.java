package vn.com.itqnu.onlinetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.onlinetest.entity.Question;
import vn.com.itqnu.onlinetest.model.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	Question findByQuestionName(String questionName);

	@Query(value = "SELECT new vn.com.itqnu.onlinetest.model.QuestionModel(q, c, a)"
			+ " FROM Question q JOIN Competition c ON q.competitionId = c.id JOIN Answer a ON q.id = a.questionId"
			+ " WHERE q.competitionId = ?1")
	
//	@Query(value = "SELECT new vn.com.itqnu.onlinetest.model.QuestionModel(q, c)"
//			+ " FROM Question q JOIN ChosenCompetition c ON q.competitionId = c.id JOIN 
	List<QuestionModel> findByCompetitionId(Long competitionId);
}
