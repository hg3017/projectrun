package DTO;

import java.util.Date;

public class LocationDTO {
	private String id;
	private String name;
	private String detail;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public LocationDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "LocationDTO [id=" + id + ", name=" + name + ", detail=" + detail + "]";
	}
	
	
	
	
	
}
