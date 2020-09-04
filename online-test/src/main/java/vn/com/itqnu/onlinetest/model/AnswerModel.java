package vn.com.itqnu.onlinetest.model;

public class AnswerModel {

	private long id;
	private String answerName;
	private String answerCode;
	private int questionId;

	public AnswerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerModel(String answerName, String answerCode, int questionId) {
		super();
		this.answerName = answerName;
		this.answerCode = answerCode;
		this.questionId = questionId;
	}

	public AnswerModel(long id, String answerName, String answerCode, int questionId) {
		super();
		this.id = id;
		this.answerName = answerName;
		this.answerCode = answerCode;
		this.questionId = questionId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public String getAnswerCode() {
		return answerCode;
	}

	public void setAnswerCode(String answerCode) {
		this.answerCode = answerCode;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

}
