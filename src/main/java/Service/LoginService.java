package Service;

import java.util.List;

import DTO.CustomerboardDTO;
import DTO.LoginDTO;

public interface LoginService {
	
	// DAO 를 호출하기 위한 Service 객체입니다. interface 를 통해 미리 정의합니다.
	public LoginDTO selectView(String id);

	public List<CustomerboardDTO> ViewPage();
	
	
	
}
