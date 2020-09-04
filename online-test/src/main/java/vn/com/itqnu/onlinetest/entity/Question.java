package vn.com.itqnu.onlinetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_question")
public class Question extends BaseEntity {

	@Column(name = "question_name")
	private String questionName;
	// A or B or C or D
	@Column(name = "result1")
	private String result;
	private int level;

	@Column(name = "subject_id")
	private Long subjectId;
	@Column(name = "competition_id")
	private Long competitionId;

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

}
