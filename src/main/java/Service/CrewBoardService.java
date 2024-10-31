package Service;

import java.util.List;
import java.util.Map;

import DTO.CrewBoardDTO;

public interface CrewBoardService {
	public List<CrewBoardDTO> selectList(Map<String, String> map);
	public int insertWrite (CrewBoardDTO dto);
	public int updateEdit(CrewBoardDTO dto, String path);
	public int deletePost(CrewBoardDTO dto);
	public int selectCount(Map<String, String> map);
	public void updateVisitCount(String idx);
	public CrewBoardDTO pnPage(String idx);
	public List<String> selectCrewNames(String id);
}