package Service;

import java.util.List;

import DAO.CrewDAO;
import DAO.CrewMemberDAO;
import DTO.CrewDTO;
import DTO.CrewMemberDTO;


// DAO 를 호출하기 위한 Service 객체입니다. LoginService 에서 상속받아 @Override 를 통해 구현합니다.
// Override : 부모 클래스의 동작 방법을 재정의 하여 선언합니다.

public class CrewServiceImpl implements CrewService {

	CrewDAO dao;
	
	
	public CrewServiceImpl() {
		this.dao = new CrewDAO();
		
	}

	
	@Override
	public List<CrewDTO> selectCrewList() {
		return dao.selectCrewList();
	}
	
	@Override
	public CrewDTO selectCrew(String name) {
		return dao.selectCrew(name);
	}
	
	@Override
	public int registCrew(CrewDTO dto) {
		return dao.registCrew(dto);
	}
	
	@Override
	public int registCrewMaster(String crew_name, String member_id) {
		return dao.registCrewMaster(crew_name, member_id);
	}
	
}
