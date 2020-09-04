package vn.com.itqnu.onlinetest.model;

import java.util.Date;

public class CompetitionModel {

	private Long id;
	private String competitionName;
	private String detail;
	private Date timeStart;
	private Date timeEnd;

	public CompetitionModel() {
		super();
	}
	public CompetitionModel(String competitionName, String detail, Date timeStart, Date timeEnd) {
		super();
		this.competitionName = competitionName;
		this.detail = detail;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		
	}
	public CompetitionModel(Long id, String competitionName, String detail, Date timeStart, Date timeEnd) {
		super();
		this.id = id;
		this.competitionName = competitionName;
		this.detail = detail;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

