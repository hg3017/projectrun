package member.dto;

public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String regidate;
	private String email;
	private int age;
	
	public MemberDTO() {
	}

	public MemberDTO(String id, String pass, String name, String regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}

	public MemberDTO(String id, String pass, String name, String regidate, String email, int age) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
		this.email = email;
		this.age = age;
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

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + ", email="
				+ email + ", age=" + age + "]";
	}	
	
}
