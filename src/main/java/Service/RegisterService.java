package Service;

import DTO.RegisterDTO;

public interface RegisterService {
	
	// DAO 를 호출하기 위한 Service 객체입니다. interface 를 통해 미리 정의합니다.
	public int insertMembership(RegisterDTO dto);

}

