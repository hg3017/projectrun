package Service;

import java.util.List;
import java.util.Map;

import DTO.AnnouncementDTO;


public interface AnnouncementService {
	
	public List<AnnouncementDTO> selectList(Map<String, String> map);
	public int insertWrite(AnnouncementDTO dto);
	public int updateEdit(AnnouncementDTO dto);
	public int deletePost(AnnouncementDTO dto);
	public int selectCount(Map<String, String> map);
	public void updateVisitCount(String idx);
	public AnnouncementDTO pnPage(String idx);
}
