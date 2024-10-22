package DTO;

import java.util.Date;

public class AdminCrewDTO {
	private int idx;
	private String name;
	private String location_id;
	private String descripton;
	private Date regidate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	
	
	
	
	public String getDescripton() {
		return descripton;
	}
	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}
	
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	@Override
	public String toString() {
		return "CrewDTO [idx=" + idx + ", name=" + name + ", location_id=" + location_id + ", regidate=" + regidate
				+ "]";
	}
	
	
	
	
	
}
