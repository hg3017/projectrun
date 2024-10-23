package Service;

import java.util.List;
import java.util.Map;

import DTO.CrewBoardDTO;

public interface CrewBoardService {
	public List<CrewBoardDTO> selectList(Map<String, String> map);
	
	public int selectCount(Map<String, String> map);
}
