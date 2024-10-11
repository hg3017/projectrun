package Service;

import java.util.List;

import DAO.LoginDAO;
import DTO.LoginDTO;


// DAO 를 호출하기 위한 Service 객체입니다. LoginService 에서 상속받아 @Override 를 통해 구현합니다.
// Override : 부모 클래스의 동작 방법을 재정의 하여 선언합니다.

public class LoginServiceImpl implements LoginService {

	LoginDAO dao;
	
	public LoginServiceImpl() {
		this.dao = new LoginDAO();
	}

	
	@Override
	public LoginDTO selectView(String id) {
		return dao.selectView(id);
	}
	
}
