package Service;

import java.util.List;

import DTO.CrewMemberDTO;

public interface CrewMemberService {
	
	public List<CrewMemberDTO> selectCrewMemberList(String crew_name);
	
	public int insertCrewMember(String crew_name, String member_id);
	
	public int deleteCrewMember(String crew_name, String member_id);
	
}
