package vn.com.itqnu.onlinetest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_result")
public class Result extends BaseEntity {

	@Column(name = "user_id")
	private int userId;
	@Column(name = "code_test")
	private int codeTest;
	@Column(name = "list_question")
	private String listQuestion;
	@Column(name = "list_answer")
	private String listAnswer;
	@Column(name = "time_start")
	private Date timeStart;
	@Column(name = "time_end")
	private Date timeEnd;
	private int score;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCodeTest() {
		return codeTest;
	}

	public void setCodeTest(int codeTest) {
		this.codeTest = codeTest;
	}

	public String getListQuestion() {
		return listQuestion;
	}

	public void setListQuestion(String listQuestion) {
		this.listQuestion = listQuestion;
	}

	public String getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(String listAnswer) {
		this.listAnswer = listAnswer;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
