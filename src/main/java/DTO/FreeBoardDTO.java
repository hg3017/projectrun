package DTO;

import java.sql.Date;

public class FreeBoardDTO {
    // 멤버 변수 선언
    private String idx;
    private String title;
    private String content;
    private String member_id;
    private String ofile;
    private String sfile;
    private Date regidate;
    private String visitcount;
    private String name;
    private String prevNum;
    private String prevTitle;
    private String nextNum;
    private String nextTitle;
    
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
	public String getOfile() {
		return ofile;
	}
	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public String getSfile() {
		return sfile;
	}
	public void setSfile(String sfile) {
		this.sfile = sfile;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public String getVisitcount() {
		return visitcount;
	}
	public void setVisitcount(String visitcount) {
		this.visitcount = visitcount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrevNum() {
		return prevNum;
	}
	public void setPrevNum(String prevNum) {
		this.prevNum = prevNum;
	}
	public String getPrevTitle() {
		return prevTitle;
	}
	public void setPrevTitle(String prevTitle) {
		this.prevTitle = prevTitle;
	}
	public String getNextNum() {
		return nextNum;
	}
	public void setNextNum(String nextNum) {
		this.nextNum = nextNum;
	}
	public String getNextTitle() {
		return nextTitle;
	}
	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}
	
	@Override
	public String toString() {
		return "FreeBoardDTO [idx=" + idx + ", title=" + title + ", content=" + content + ", member_id=" + member_id
				+ ", ofile=" + ofile + ", sfile=" + sfile + ", regidate=" + regidate + ", visitcount=" + visitcount
				+ ", name=" + name + ", prevNum=" + prevNum + ", prevTitle=" + prevTitle + ", nextNum=" + nextNum
				+ ", nextTitle=" + nextTitle + "]";
	}
    
	
}
