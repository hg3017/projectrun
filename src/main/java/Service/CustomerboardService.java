package Service;

import java.util.List;
import java.util.Map;

import DTO.CustomerboardDTO;
import DTO.FreeBoardDTO;

public interface CustomerboardService {
	public List<CustomerboardDTO> selectList(Map<String, String> map);
	public int insertWrite(CustomerboardDTO dto);
	public int updateEdit(CustomerboardDTO dto);
	public int deletePost(CustomerboardDTO dto);
	public int selectCount(Map<String, String> map);
	public CustomerboardDTO ViewPage(String idx);
	
}
