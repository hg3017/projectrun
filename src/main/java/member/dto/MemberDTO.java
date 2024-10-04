package member.dto;

public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private int grade;
	private String nickname;
	private String location;
	private int phone_number;
	
	public MemberDTO() {
	}

	public MemberDTO(String id, String pass, String name, int grade, String nickname, String location,
			int phone_number) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.grade = grade;
		this.nickname = nickname;
		this.location = location;
		this.phone_number = phone_number;
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

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", grade=" + grade + ", nickname="
				+ nickname + ", location=" + location + ", phone_number=" + phone_number + "]";
	}

	
}
