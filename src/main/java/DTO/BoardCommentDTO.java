package DTO;

import java.sql.Date;

public class BoardCommentDTO {
	private int comment_num;
	private int board_num;
	private String id;
	private String content;
	private Date regidate;
	
	public BoardCommentDTO(int comment_num, int board_num, String id, String content, Date regidate) {
		super();
		this.comment_num = comment_num;
		this.board_num = board_num;
		this.id = id;
		this.content = content;
		this.regidate = regidate;
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "BoardCommentDTO [comment_num=" + comment_num + ", board_num=" + board_num + ", id=" + id + ", content="
				+ content + ", regidate=" + regidate + "]";
	}
	
	
	
}
