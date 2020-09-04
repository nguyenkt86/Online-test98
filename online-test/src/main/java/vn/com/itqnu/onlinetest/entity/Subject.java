package vn.com.itqnu.onlinetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_subject")
public class Subject extends BaseEntity {

	@Column(name = "sunject_name")
	private String subjectName;


	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
