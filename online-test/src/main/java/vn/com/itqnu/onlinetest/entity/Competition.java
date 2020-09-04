package vn.com.itqnu.onlinetest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_competition")
public class Competition extends BaseEntity {

	@Column(name = "competition_name")
	private String competitionName;
	private String detail;
	@Column(name = "time_start")
	private Date timeStart;
	@Column(name = "time_end")
	private Date timeEnd;

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

}
