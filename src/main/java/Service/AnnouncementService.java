package Service;

import java.util.List;
import java.util.Map;

import DTO.AnnouncementDTO;


public interface AnnouncementService {
	
	//public List<AnnouncementDTO> selectList();
	public List<AnnouncementDTO> selectList(Map<String, String> map);
	public AnnouncementDTO selectView(String num);
	public int insertWrite(AnnouncementDTO dto);
	public int updateEdit(AnnouncementDTO dto);
	public int deletePost(AnnouncementDTO dto);
	public int selectCount(Map<String, String> map);
}
