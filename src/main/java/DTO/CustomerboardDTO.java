package DTO;

import java.util.Date;

public class CustomerboardDTO {
	private String idx;
	private String category;
	private String ableview;
	private String title;
	private String member_id;
	private String content;
	private Date regidate;
	private int visitcount;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAbleview() {
		return ableview;
	}

	public void setAbleview(String ableview) {
		this.ableview = ableview;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	public int getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(int visitcount) {
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
		return "CustomerboardDTO [idx=" + idx + ", category=" + category + ", ableview=" + ableview + ", title=" + title
				+ ", member_id=" + member_id + ", content=" + content + ", regidate=" + regidate + ", visitcount="
				+ visitcount + ", prevnum=" + prevnum + ", prevtitle=" + prevtitle + ", nextnum=" + nextnum
				+ ", nexttitle=" + nexttitle + "]";
	}




	
	
	
}
