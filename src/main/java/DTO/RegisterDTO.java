package DTO;

public class RegisterDTO {
	
	private String id;
	private String pass;
	private String name;
	private int grade;
	private String nickname;
	private int location;
	private int phone_number;
	
	
	
	// Login 에 필요한 객체를 생성하기 위해 미리 데이터 객체의 형태를 정의합니다. 
	public RegisterDTO() {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.grade = grade;
		this.nickname = nickname;
		this.location = location;
		this.phone_number = phone_number;
	}
	
	// DTO 객체에서 ID 값을 가져옵니다. 
	public String getId() {
		return id;
	}
	
	// DTO 객체의 ID 값을 정의합니다. 
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
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	// 해당 객체의 내용을 출력합니다. 
	@Override
	public String toString() {
		return "RegisterDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", grade=" + grade + ", nickname="
				+ nickname + ", location=" + location + ", phone_number=" + phone_number + "]";
	}
	
	
	
	
}
