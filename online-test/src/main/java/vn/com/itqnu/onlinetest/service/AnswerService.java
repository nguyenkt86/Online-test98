package vn.com.itqnu.onlinetest.service;

import java.util.List;

import vn.com.itqnu.onlinetest.entity.Answer;
import vn.com.itqnu.onlinetest.model.AnswerModel;

public interface AnswerService {
	
	List<Answer> getAllAnswer();
	
	Answer getAnswerByID(Long idAnswer);

	Answer createAnswer(AnswerModel answerModel);
	
	Answer updateAnswer(AnswerModel answerModel);
	
	void deleteAnswer(Long idAnswer);
}


