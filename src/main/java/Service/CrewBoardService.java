package Service;

import java.util.List;
import java.util.Map;

import DAO.CrewMemberDAO;
import DTO.CrewBoardDTO;
import DTO.CrewMemberDTO;

public interface CrewBoardService {
	public List<CrewBoardDTO> selectList(Map<String, String> map);
	public int insertWrite(CrewBoardDTO dto, CrewMemberDTO dto2);
	// public int insertWrite (CrewBoardDTO dto);
	public int updateEdit(CrewBoardDTO dto);
	public int deletePost(CrewBoardDTO dto);
	public int selectCount(Map<String, String> map);
	public void updateVisitCount(String idx);
	public CrewBoardDTO pnPage(String idx);
	public CrewMemberDTO getCrewName(String member_id);
    // String crew_name = service.getCrewName(member_id);;

}
