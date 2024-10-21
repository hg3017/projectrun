package DTO;

import java.util.Date;

public class CrewMemberDTO {
	private int idx;
	private String crew_name;
	private String member_id;
	private String status;
	private int member_image;
	private String description;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCrew_name() {
		return crew_name;
	}
	public void setCrew_name(String crew_name) {
		this.crew_name = crew_name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getMember_image() {
		return member_image;
	}
	public void setMember_image(int member_image) {
		this.member_image = member_image;
	}
	
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "CrewMemberDTO [idx=" + idx + ", crew_name=" + crew_name + ", member_id=" + member_id + ", status="
				+ status + "]";
	}
	
	
	
	
}
