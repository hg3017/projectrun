package Service;

import java.util.List;

import DTO.AnnouncementDTO;


public interface AnnouncementService {
	
	public List<AnnouncementDTO> selectList();
	public AnnouncementDTO selectView(String num);
	public int insertWrite(AnnouncementDTO dto);
	public int updateEdit(AnnouncementDTO dto);
}
