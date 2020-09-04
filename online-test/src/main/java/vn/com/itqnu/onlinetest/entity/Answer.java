package vn.com.itqnu.onlinetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_answer")
public class Answer extends BaseEntity {

	@Column(name = "answer_name")
	private String answerName;
	// A, B, C, D
	@Column(name = "answer_code")
	private String answerCode;
	@Column(name = "question_id")
	private int questionId;

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
