package vn.com.itqnu.onlinetest.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Answer;
import vn.com.itqnu.onlinetest.model.AnswerModel;
import vn.com.itqnu.onlinetest.repository.AnswerRepository;
import vn.com.itqnu.onlinetest.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	private AnswerRepository answerRepository;
	
	public AnswerServiceImpl(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	@Override
	public List<Answer> getAllAnswer() {
		return answerRepository.findAll();
	}

	@Override
	public Answer getAnswerByID(Long idAnswer) {
		Optional<Answer> optional = answerRepository.findById(idAnswer);
		if (optional != null && optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Answer createAnswer(AnswerModel answerModel) {
		if (answerModel.getAnswerName()== null || answerModel.getAnswerName().trim().length() == 0) {
			throw new RuntimeException("Answer name is required!");
		}
		
		//

		Answer answer = new Answer();
		answer.setAnswerName(answerModel.getAnswerName());
		answer.setAnswerCode(answerModel.getAnswerCode());
		answer.setQuestionId(answerModel.getQuestionId());

		answer.setCreatedBy("ADMIN");
		answer.setCreatedDate(new Date());
		answer.setModifiedBy("ADMIN");
		answer.setModifiedDate(new Date());

		answerRepository.save(answer);
		
		return answer;
	}

	@Override
	public Answer updateAnswer(AnswerModel answerModel) {
		Answer answer = getAnswerByID(answerModel.getId());
		if (answer == null) {
			throw new RuntimeException("Answer does not exits!");
		}
		answer.setAnswerName(answerModel.getAnswerName());
		answer.setAnswerCode(answerModel.getAnswerCode());
		answer.setQuestionId(answerModel.getQuestionId());
		answer.setModifiedBy("ADMIN");
		answer.setModifiedDate(new Date());

		answerRepository.save(answer);

		return answer;

	}

	@Override
	public void deleteAnswer(Long idAnswer) {
		Answer answer = getAnswerByID(idAnswer);

		if (answer == null) {
			throw new RuntimeException("Answer does not exits!");
		}
		answerRepository.delete(answer);
		
	}

}
