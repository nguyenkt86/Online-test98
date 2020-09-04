package vn.com.itqnu.onlinetest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Competition;
import vn.com.itqnu.onlinetest.entity.Question;
import vn.com.itqnu.onlinetest.model.QuestionModel;
import vn.com.itqnu.onlinetest.repository.QuestionRepository;
import vn.com.itqnu.onlinetest.service.CompetitionService;
import vn.com.itqnu.onlinetest.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionRepository questionRepository;
	private CompetitionService competitionService;

	public QuestionServiceImpl(QuestionRepository questionRepository, CompetitionService competitionService) {
		this.questionRepository = questionRepository;
		this.competitionService = competitionService;
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public Question getQuestionByID(Long idQuestion) {
		Optional<Question> optional = questionRepository.findById(idQuestion);
		if (optional != null && optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Question createQuestion(QuestionModel questionModel) {
		if (questionModel.getQuestionName() == null || questionModel.getQuestionName().trim().length() == 0) {
			throw new RuntimeException("Question name is required!");
		}

		Competition competition = competitionService.getCompetitionById(questionModel.getCompetitionId());
		if (competition == null) {
			throw new RuntimeException("Subject does not exits!");
		}

		Question question = new Question();
		question.setQuestionName(questionModel.getQuestionName());
		question.setResult(questionModel.getResult());
		question.setCompetitionId(questionModel.getCompetitionId());
		question.setLevel(questionModel.getLevel());

		question.setCreatedBy("ADMIN");
		question.setCreatedDate(new Date());
		question.setModifiedBy("ADMIN");
		question.setModifiedDate(new Date());

		questionRepository.save(question);

		return question;
	}

	@Override
	public Question updateQuestion(QuestionModel questionModel) {
		Question question = getQuestionByID(questionModel.getId());
		if (question == null) {
			throw new RuntimeException("Question does not exits!");
		}

		question.setQuestionName(questionModel.getQuestionName());
		question.setResult(questionModel.getResult());

		question.setModifiedBy("ADMIN");
		question.setModifiedDate(new Date());

		questionRepository.save(question);

		return question;
	}

	@Override
	public void deleteQuestion(Long idQuestion) {
		Question question = getQuestionByID(idQuestion);

		if (question == null) {
			throw new RuntimeException("Question does not exits!");
		}
		questionRepository.delete(question);

	}

	@Override
	public List<QuestionModel> getQuestionByCompetition(Long idCompetition) {
		return questionRepository.findByCompetitionId(idCompetition);
	}

	@Override
	public List<QuestionModel> buildTest(List<QuestionModel> listQuestionModels) {
		List<QuestionModel> listQuestionTest = new ArrayList<>();
		List<QuestionModel> listQuestionEasy = new ArrayList<>();
		List<QuestionModel> listQuestionNormal = new ArrayList<>();
		List<QuestionModel> listQuestionHard = new ArrayList<>();

		for (QuestionModel questionModel : listQuestionModels) {
			if (questionModel.getLevel() == 1) {
				listQuestionEasy.add(questionModel);
			} else if (questionModel.getLevel() == 2) {
				listQuestionNormal.add(questionModel);
			} else {
				listQuestionHard.add(questionModel);
			}
		}
		
		int index = 0;
		for (int i = 0; i < 10; i ++) {
			index = new Random().nextInt(listQuestionEasy.size());
			listQuestionTest.add(listQuestionEasy.get(index));
		}
		for (int i = 0; i < 10; i ++) {
			index = new Random().nextInt(listQuestionNormal.size());
			listQuestionTest.add(listQuestionNormal.get(index));
		}
		for (int i = 0; i < 10; i ++) {
			index = new Random().nextInt(listQuestionHard.size());
			listQuestionTest.add(listQuestionHard.get(index));
		}

		return listQuestionTest;
	}

}
