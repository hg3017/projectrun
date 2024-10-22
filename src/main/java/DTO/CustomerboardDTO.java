package DTO;

import java.util.Date;

public class CustomerboardDTO {
	private int idx;
	private int ableview;
	private String category;
	private String title;
	private String content;
	private String member_id;
	private Date regidate;
	private int visitcount;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getAbleview() {
		return ableview;
	}
	public void setAbleview(int ableview) {
		this.ableview = ableview;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	
	
	@Override
	public String toString() {
		return "CustomerboardDTO [idx=" + idx + ", ableview=" + ableview + ", category=" + category + ", title=" + title
				+ ", content=" + content + ", member_id=" + member_id + ", regidate=" + regidate + ", visitcount="
				+ visitcount + "]";
	}
	
	
}
