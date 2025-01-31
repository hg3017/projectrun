package DTO;

import java.util.Date;

public class CommentDTO {
	private String idx;
	private String member_id;
	private String board_type;
	private String board_idx;
	private String content;
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
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public String getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(String board_idx) {
		this.board_idx = board_idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.sql.Date getRegidate() {
		return regidate;
	}
	public void setRegidate(java.sql.Date regidate) {
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "CommentDTO [idx=" + idx + ", member_id=" + member_id + ", board_type=" + board_type + ", board_idx="
				+ board_idx + ", content=" + content + ", regidate=" + regidate + "]";
	}
	
	
	
	
	
}
