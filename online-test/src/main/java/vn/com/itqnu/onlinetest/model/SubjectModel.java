package vn.com.itqnu.onlinetest.model;

public class SubjectModel {

	private long id;
	private String subjectName;

	public SubjectModel() {
		super();
	}

	public SubjectModel(String subjectName, int subjectId) {
		super();
		this.subjectName = subjectName;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public SubjectModel(long id, String subjectName, int subjectId) {
		super();
		this.id = id;
		this.subjectName = subjectName;
	}



}
