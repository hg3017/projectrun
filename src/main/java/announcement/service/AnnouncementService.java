package announcement.service;

import java.util.List;

import announcement.dto.AnnouncementDTO;


public interface AnnouncementService {
	
	public List<AnnouncementDTO> selectList();
	public AnnouncementDTO selectView(String num);
	public int insertWrite(AnnouncementDTO dto);
	public int updateEdit(AnnouncementDTO dto);
}
