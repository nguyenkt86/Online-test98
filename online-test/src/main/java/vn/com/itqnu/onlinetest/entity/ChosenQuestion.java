package vn.com.itqnu.onlinetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_chosen_question")
public class ChosenQuestion extends BaseEntity {

	@Column(name = "question_id")
	private Long questionId;
	@Column(name = "competition_id")
	private Long competitionId;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Long getCompetitionId() {
		return competitionId;
	}
	public void setCompetionId(Long competitionId) {
		this.competitionId = competitionId;
	}
	
	
}
