package Service;

import java.util.List;

import DTO.CrewDTO;

public interface CrewService {
	
	public List<CrewDTO> selectCrewList();
	
	public CrewDTO selectCrew(String name);
	
}
