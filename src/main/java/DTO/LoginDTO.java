package DTO;

public class LoginDTO {

	private String id;
	private String pass;
	
	// Login 에 필요한 객체를 생성하기 위해 미리 데이터 객체의 형태를 정의합니다. 
	public LoginDTO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
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

	
	
	
}
