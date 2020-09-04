package vn.com.itqnu.onlinetest.model;

public class ChosenQuestionModel {
	private Long id;

	public Long getId() {
		return id;
	}

	public ChosenQuestionModel() {
		super();
	}

	public ChosenQuestionModel(Long questionId, Long competitionId) {
		super();
		this.questionId = questionId;
		this.competitionId = competitionId;
	}

	public ChosenQuestionModel(Long id, Long questionId, Long competitionId) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.competitionId = competitionId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(Long competitionId) {
		this.competitionId = competitionId;
	}

	private Long questionId;
	private Long competitionId;
}
