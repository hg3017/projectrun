package DTO;

import java.sql.Date;

public class CrewBoardDTO {
	private String idx;
    private String title;
    private String crew_name;
    private String content;
    private String member_id;
    private java.sql.Date regidate;
    private String visitcount;
    private String prevnum;
	private String prevtitle;
	private String nextnum;
	private String nexttitle;
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
	public java.sql.Date getRegidate() {
		return regidate;
	}
	public void setRegidate(java.sql.Date regidate) {
		this.regidate = regidate;
	}
	public String getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}
	public String getPrevnum() {
		return prevnum;
	}
	public void setPrevnum(String prevnum) {
		this.prevnum = prevnum;
	}
	public String getPrevtitle() {
		return prevtitle;
	}
	public void setPrevtitle(String prevtitle) {
		this.prevtitle = prevtitle;
	}
	public String getNextnum() {
		return nextnum;
	}
	public void setNextnum(String nextnum) {
		this.nextnum = nextnum;
	}
	public String getNexttitle() {
		return nexttitle;
	}
	public void setNexttitle(String nexttitle) {
		this.nexttitle = nexttitle;
	}
	@Override
	public String toString() {
		return "CrewBoardDTO [idx=" + idx + ", title=" + title + ", crew_name=" + crew_name + ", content=" + content
				+ ", member_id=" + member_id + ", regidate=" + regidate + ", visitcount=" + visitcount + ", prevnum="
				+ prevnum + ", prevtitle=" + prevtitle + ", nextnum=" + nextnum + ", nexttitle=" + nexttitle + "]";
	}
    
	
	
	
}
