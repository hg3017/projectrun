package Service;

import java.util.List;
import java.util.Map;

import DAO.AnnouncementDAO;
import DTO.AnnouncementDTO;

public class AnnouncementServiceImpl implements AnnouncementService{
	
	AnnouncementDAO dao;
	
	public AnnouncementServiceImpl() {
		this.dao = new AnnouncementDAO();
	}

	@Override
	public List<AnnouncementDTO> selectList(Map<String, String> map) {
		
		return dao.selectList(map);
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

	@Override
	public int deletePost(AnnouncementDTO dto) {
		return dao.deletePost(dto);
	}

	@Override
	public int selectCount(Map<String, String> map) {
	    return dao.selectCount(map);
	}

	@Override
	public void updateVisitCount(String num) {
		dao.updateVisitCount(num);
	}


}
