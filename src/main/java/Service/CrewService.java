package Service;

import java.util.List;

import DTO.CrewDTO;
import DTO.CrewMemberDTO;

public interface CrewService {
	
	public List<CrewDTO> selectCrewList();
	
	public CrewDTO selectCrew(String name);
	
	public int registCrew(CrewDTO dto);
	
	public int registCrewMaster(String crew_name, String member_id);
	
}
