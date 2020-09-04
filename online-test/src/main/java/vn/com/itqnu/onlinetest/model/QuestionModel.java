package vn.com.itqnu.onlinetest.model;

import vn.com.itqnu.onlinetest.entity.Answer;
import vn.com.itqnu.onlinetest.entity.Competition;
import vn.com.itqnu.onlinetest.entity.Question;

public class QuestionModel {

	private long id;
	private String questionName;
	private String result;
	private int level;
	private Long subjectId;

	private Long competitionId;
	private String competitionName;
	private Answer answer;

	public QuestionModel() {
		super();
	}

	public QuestionModel(String questionName, String result, int level, Long subjectId, Long competitionId,
			String competitionName, Answer answer) {
		super();
		this.questionName = questionName;
		this.result = result;
		this.level = level;
		this.subjectId = subjectId;
		this.competitionId = competitionId;
		this.competitionName = competitionName;
		this.answer = answer;
	}

	public QuestionModel(long id, String questionName, String result, int level, Long subjectId, Long competitionId,
			String competitionName, Answer answer) {
		super();
		this.id = id;
		this.questionName = questionName;
		this.result = result;
		this.level = level;
		this.subjectId = subjectId;
		this.competitionId = competitionId;
		this.competitionName = competitionName;
		this.answer = answer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(Long competitionId) {
		this.competitionId = competitionId;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
