package Service;

import java.util.List;
import java.util.Map;
import DTO.FreeBoardDTO;

public interface CustomerService {
	public List<FreeBoardDTO> selectList(Map<String, String> map);
	public FreeBoardDTO selectView(String rum);
	public int insertWrite(FreeBoardDTO dto);
	public int updateEdit(FreeBoardDTO dto);
	public int deletePost(FreeBoardDTO dto);
	
}
