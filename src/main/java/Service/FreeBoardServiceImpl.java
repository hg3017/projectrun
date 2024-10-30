package Service;

import java.util.List;
import java.util.Map;

import DAO.FreeBoardDAO;
import DTO.FreeBoardDTO;



public class FreeBoardServiceImpl implements FreeBoardService{
	
	FreeBoardDAO dao;
	
	public FreeBoardServiceImpl() {
		this.dao = new FreeBoardDAO();
	}

	@Override
	public List<FreeBoardDTO> selectList(Map<String, String> map) {
		
		return dao.selectList(map);
	}

	@Override
	public int insertWrite(FreeBoardDTO dto) {
		return dao.insertWrite(dto);
	}

	@Override
	public int updateEdit(FreeBoardDTO dto, String path) {
		
		return dao.updateEdit(dto, path);
	}

	@Override
	public int deletePost(FreeBoardDTO dto) {
		return dao.deletePost(dto);
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
	public FreeBoardDTO pnPage(String idx) {
		return dao.pnPage(idx);
	}


}
