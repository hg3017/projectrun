package DTO;

import java.util.Date;

public class CommentDTO {
	private String idx;
	private String member_id;
	private String content;
	private String crew_name;
	private java.sql.Date regidate;
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
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
	
	
	
	
	public String getCrew_name() {
		return crew_name;
	}
	public void setCrew_name(String crew_name) {
		this.crew_name = crew_name;
	}
	public java.sql.Date getRegidate() {
		return regidate;
	}
	public void setRegidate(java.sql.Date regidate) {
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "CommentDTO [idx=" + idx + ", member_id=" + member_id + ", content=" + content + ", crew_name="
				+ crew_name + ", regidate=" + regidate + "]";
	}
	
	
	
	
	
	
	
	
}
