package DTO;

import java.util.Date;

public class AdminCrewDTO {
	private int idx;
	private String name;
	private String location_id;
	private String description;
	private String regidate;
	
	public AdminCrewDTO() {
	}

	public AdminCrewDTO(int idx, String name, String location_id, String description, String regidate) {
		super();
		this.idx = idx;
		this.name = name;
		this.location_id = location_id;
		this.description = description;
		this.regidate = regidate;
	}
	
	
	public AdminCrewDTO(int idx, String name, String location_id, String description) {
		super();
		this.idx = idx;
		this.name = name;
		this.location_id = location_id;
		this.description = description;
	}

	public AdminCrewDTO(String name, String location_id, String description, String regidate) {
		super();
		this.name = name;
		this.location_id = location_id;
		this.description = description;
		this.regidate = regidate;
	}

	public AdminCrewDTO(String name, String location_id, String description) {
		super();
		this.name = name;
		this.location_id = location_id;
		this.description = description;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "AdminCrewDTO [idx=" + idx + ", name=" + name + ", location_id=" + location_id + ", description="
				+ description + ", regidate=" + regidate + "]";
	}
	
	
	
	
	
	
	
	
}
