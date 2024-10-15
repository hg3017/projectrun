package Service;

import java.util.List;
import java.util.Map;

import DTO.FreeBoardDTO;


public interface FreeBoardService {
	
	public List<FreeBoardDTO> selectList(Map<String, String> map);
	public FreeBoardDTO selectView(String num);
	public int insertWrite(FreeBoardDTO dto);
	public int updateEdit(FreeBoardDTO dto);
	public int deletePost(FreeBoardDTO dto);
}
