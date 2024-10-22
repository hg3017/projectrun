package DTO;

import java.sql.Date;

public class FileDTO {
	private int idx;
	private String member_id;
	private String title;
    private String content;
    private String ofile;
    private String sfile;
    private Date regidate;
    
    public FileDTO() {
	}
    
	public FileDTO(int idx, String member_id, String title, String content, String ofile, String sfile, Date regidate) {
		super();
		this.idx = idx;
		this.member_id = member_id;
		this.title = title;
		this.content = content;
		this.ofile = ofile;
		this.sfile = sfile;
		this.regidate = regidate;
	}
    
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
	@Override
	public String toString() {
		return "FileDTO [idx=" + idx + ", member_id=" + member_id + ", title=" + title + ", content=" + content
				+ ", ofile=" + ofile + ", sfile=" + sfile + ", regidate=" + regidate + "]";
	}
    
    
    
}
