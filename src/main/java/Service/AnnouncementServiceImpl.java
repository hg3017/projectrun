package Service;

import java.util.List;

import DAO.AnnouncementDAO;
import DTO.AnnouncementDTO;


public class AnnouncementServiceImpl implements AnnouncementService{
	
	AnnouncementDAO dao;
	
	public AnnouncementServiceImpl() {
		this.dao = new AnnouncementDAO();
	}

	@Override
	public List<AnnouncementDTO> selectList() {
		
		return dao.selectList(null);
	}

	@Override
	public int insertWrite(AnnouncementDTO dto) {
		return dao.insertWrite(dto);
	}

	@Override
	public AnnouncementDTO selectView(String num) {
		
		return dao.selectView(num);
	}

	@Override
	public int updateEdit(AnnouncementDTO dto) {
		
		return dao.updateEdit(dto);
	}


}
