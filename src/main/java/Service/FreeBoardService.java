package Service;

import java.util.List;
import java.util.Map;

import DTO.FreeBoardDTO;


public interface FreeBoardService {
	
	public List<FreeBoardDTO> selectList(Map<String, String> map);
	public int insertWrite(FreeBoardDTO dto);
	public int updateEdit(FreeBoardDTO dto, String path);
	public int deletePost(FreeBoardDTO dto);
	public int selectCount(Map<String, String> map);
	public void updateVisitCount(String idx);
	public FreeBoardDTO pnPage(String idx);
}
