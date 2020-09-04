package vn.com.itqnu.onlinetest.service;

import java.util.List;

import vn.com.itqnu.onlinetest.entity.Question;
import vn.com.itqnu.onlinetest.model.QuestionModel;

public interface QuestionService {

	List<Question> getAllQuestion();
	
	Question getQuestionByID(Long idQuestion);

	Question createQuestion(QuestionModel questionModel);
	
	Question updateQuestion(QuestionModel questionModel);
	
	void deleteQuestion(Long idQuestion);
	
	List<QuestionModel> getQuestionByCompetition(Long idCompetition);
	
	List<QuestionModel> buildTest(List<QuestionModel> listQuestionModels);
}
