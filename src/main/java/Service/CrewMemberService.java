package Service;

import java.util.List;

import DTO.CrewMemberDTO;

public interface CrewMemberService {
	
	public List<CrewMemberDTO> selectCrewMemberList(String crew_name);
	
	public List<CrewMemberDTO> selectCrewMainMemberList(String crew_name);
	
	public String selectCrewMemberStatus(String crew_name, String member_id);
		
	public int insertCrewMember(String crew_name, String member_id);
	
	public int deleteCrewMember(String crew_name, String member_id);
	
	public int acceptCrewMember(String crew_name, String member_id);
	
	public int refuseCrewMember(String crew_name, String member_id);
	
}
