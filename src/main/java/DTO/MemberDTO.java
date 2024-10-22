package DTO;

public class MemberDTO {
	// 접근제어자 private로 변수 선언
	private int idx;
	private String id;
	private String pass;
	private String name;
	private int grade;
	private String nickname;
	private String location;
	private String phone_number;
	private String description;
	private String regidate;
	private String editdate;
	private int member_image_idx;
	
	// 기본 생성자
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	// 오버라이딩된 생성자
	public MemberDTO(int idx, String id, String pass, String name, int grade, String nickname, String location,
			String phone_number, String description, String regidate, String editdate, int member_image_idx) {
		super();
		this.idx = idx;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.grade = grade;
		this.nickname = nickname;
		this.location = location;
		this.phone_number = phone_number;
		this.description = description;
		this.regidate = regidate;
		this.editdate = editdate;
		this.member_image_idx = member_image_idx;
	}

	// 오버라이딩된 생성자
	public MemberDTO(int idx, String id, String pass, String name, int grade, String nickname, String location,
			String phone_number, String regidate, String editdate, int member_image_idx) {
		super();
		this.idx = idx;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.grade = grade;
		this.nickname = nickname;
		this.location = location;
		this.phone_number = phone_number;
		this.regidate = regidate;
		this.editdate = editdate;
		this.member_image_idx = member_image_idx;
	}

	// 오버라이딩된 생성자
	public MemberDTO(String id, String pass, String name, int grade, String nickname, String location,
			String phone_number) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.grade = grade;
		this.nickname = nickname;
		this.location = location;
		this.phone_number = phone_number;
	}
	
	// 오버라이딩된 생성자
	public MemberDTO(String id, String pass, String name, String nickname, String location, String phone_number) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.nickname = nickname;
		this.location = location;
		this.phone_number = phone_number;
	}

	// getter 메서드 setter 메서드
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
	public String getEditdate() {
		return editdate;
	}
	public void setEditdate(String editdate) {
		this.editdate = editdate;
	}
	public int getMember_image_idx() {
		return member_image_idx;
	}
	public void setMember_image_idx(int member_image_idx) {
		this.member_image_idx = member_image_idx;
	}

	// toString 메서드
	@Override
	public String toString() {
		return "MemberDTO [idx=" + idx + ", id=" + id + ", pass=" + pass + ", name=" + name + ", grade=" + grade
				+ ", nickname=" + nickname + ", location=" + location + ", phone_number=" + phone_number
				+ ", description=" + description + ", regidate=" + regidate + ", editdate=" + editdate
				+ ", member_image_idx=" + member_image_idx + "]";
	}
	
	
}
