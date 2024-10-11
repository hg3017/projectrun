package Service;

import DAO.RegisterDAO;
import DTO.RegisterDTO;


public class RegisterServiceImpl implements RegisterService {
	
	RegisterDAO dao;
	
	// DAO 를 호출하기 위한 Service 객체입니다. LoginService 에서 상속받아 @Override 를 통해 구현합니다.
	// Override : 부모 클래스의 동작 방법을 재정의 하여 선언합니다.
	
	public RegisterServiceImpl() {
		this.dao = new RegisterDAO();
	}
	
	@Override
	public int insertMembership(RegisterDTO dto) {
		// dao 의 insertMember 를 실행시킵니다. 
		return dao.insertMember(dto);
	}	
	

}



