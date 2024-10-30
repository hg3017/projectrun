package Service;

import java.sql.SQLException;
import java.util.List;

import Common.DBConnectionPool;
import DAO.LoginDAO;
import DTO.CustomerboardDTO;
import DTO.LoginDTO;


// DAO 를 호출하기 위한 Service 객체입니다. LoginService 에서 상속받아 @Override 를 통해 구현합니다.
// Override : 부모 클래스의 동작 방법을 재정의 하여 선언합니다.

public class LoginServiceImpl implements LoginService {

	LoginDAO dao;
	
    public LoginServiceImpl() {
        try {
        	DBConnectionPool dbConnectionPool = new DBConnectionPool();
            this.dao = new LoginDAO(dbConnectionPool);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("DBConnectionPool 초기화 실패");
        }
    }

	@Override
	public LoginDTO selectView(String id) {
		return dao.selectView(id);
	}

	@Override
	public List<CustomerboardDTO> ViewPage() {
		return dao.ViewPage();
	}
	
}
