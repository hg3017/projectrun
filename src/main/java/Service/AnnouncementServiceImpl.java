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
	public int updateEdit(AnnouncementDTO dto, String path) {
		
		return dao.updateEdit(dto, path);
	}

	@Override
	public int deletePost(String idx) {
		return dao.deletePost(idx);
	}

	@Override
	public int selectCount(Map<String, String> map) {
	    return dao.selectCount(map);
	}

	@Override
	public void updateVisitCount(String idx) {
		dao.updateVisitCount(idx);
	}

	@Override
	public AnnouncementDTO pnPage(String idx) {
		return dao.pnPage(idx);
	}


}
