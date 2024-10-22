package Service;

import java.util.List;

import DAO.CrewDAO;
import DAO.CrewMemberDAO;
import DTO.CrewDTO;
import DTO.CrewMemberDTO;


// DAO 를 호출하기 위한 Service 객체입니다. LoginService 에서 상속받아 @Override 를 통해 구현합니다.
// Override : 부모 클래스의 동작 방법을 재정의 하여 선언합니다.

public class CrewMemberServiceImpl implements CrewMemberService {

	CrewMemberDAO dao;
	
	public CrewMemberServiceImpl() {
		this.dao = new CrewMemberDAO();
	}

	
	@Override
	public List<CrewMemberDTO> selectCrewMemberList(String crew_name) {
		return dao.selectCrewMemberList(crew_name);
	}
	
	@Override
	public List<CrewMemberDTO> selectCrewMainMemberList(String crew_name) {
		return dao.selectCrewMainMemberList(crew_name);
	}
	
	@Override
	public String selectCrewMemberStatus(String crew_name, String member_id) {
		return dao.selectCrewMemberStatus(crew_name, member_id);
		
	}
	
	@Override
	public int insertCrewMember(String crew_name, String member_id) {
		return dao.insertCrewMember(crew_name, member_id);
	}
	
	@Override
	public int acceptCrewMember(String crew_name, String member_id) {
		return dao.acceptCrewMember(crew_name, member_id);
	}
	
	@Override
	public int deleteCrewMember(String crew_name, String member_id) {
		return dao.deleteCrewMember(crew_name, member_id);
	}
	
	@Override
	public int refuseCrewMember(String crew_name, String member_id) {
		return dao.refuseCrewMember(crew_name, member_id);
	}
	
}
