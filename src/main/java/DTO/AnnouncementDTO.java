package DTO;

import java.sql.Date;

public class AnnouncementDTO {
    // 멤버 변수 선언
    private String num;
    private String title;
    private String content;
    private String id;
    private Date postdate;
    private String visitcount;
    private String name;
    private String prevNum;
    private String prevTitle;
    private String nextNum;
    private String nextTitle;

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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
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
	@Override
	public String toString() {
		return "AnnouncementDTO [num=" + num + ", title=" + title + ", content=" + content + ", id=" + id
				+ ", postdate=" + postdate + ", visitcount=" + visitcount + ", name=" + name + ", prevNum=" + prevNum
				+ ", prevTitle=" + prevTitle + ", nextNum=" + nextNum + ", nextTitle=" + nextTitle + "]";
	}
}
