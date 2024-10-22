package DTO;

import java.sql.Date;

public class CrewBoardDTO {
	private String idx;
    private String title;
    private String crew_name;
    private String content;
    private String member_id;
    private java.sql.Date postdate;
    private String visitcount;
    

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCrew_name() {
		return crew_name;
	}

	public void setCrew_name(String crew_name) {
		this.crew_name = crew_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public java.sql.Date getPostdate() {
		return postdate;
	}

	public void setPostdate(java.sql.Date postdate) {
		this.postdate = postdate;
	}

	public String getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}
	
	
}
