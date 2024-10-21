package DTO;

public class AdminCrewDTO {

	// Data Transfer Object : 데이터 전송 오브젝트
	// 데이터베이스에서 데이터를 받아오고 보내기 위한 오브젝트이다.
	// 변수 부분, 생성자 부분, getter&setter 메서드 부분, toString 부분으로 구성된다.
	
	// 접근제어자 private로 crew 테이블의 컬럼 5개 변수로 선언
	private int idx;
	private String name;
	private String location_id;
	private String description;
	private String regidate;
	
	// 기본 생성자
	public AdminCrewDTO() {
		// TODO Auto-generated constructor stub
	}

	// 오버라이딩된 생성자
	public AdminCrewDTO(int idx, String name, String location_id, String description, String regidate) {
		super();
		this.idx = idx;
		this.name = name;
		this.location_id = location_id;
		this.description = description;
		this.regidate = regidate;
	}
	
	public AdminCrewDTO(String name, String location_id, String description, String regidate) {
		super();
		this.name = name;
		this.location_id = location_id;
		this.description = description;
		this.regidate = regidate;
	}
	// 오버라이딩된 AdminCrewDTO 생성자 선언
	public AdminCrewDTO(String name, String location_id, String description) {
		super();
		this.name = name;
		this.location_id = location_id;
		this.description = description;
	}

	// getter 메서드 setter 메서드
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


	// toString 메서드
	@Override
	public String toString() {
		return "AdminCrewDTO [idx=" + idx + ", name=" + name + ", location_id=" + location_id + ", description="
				+ description + ", regidate=" + regidate + "]";
	}

	

}
