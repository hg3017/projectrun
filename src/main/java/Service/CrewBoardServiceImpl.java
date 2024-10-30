package Service;

import java.util.List;
import java.util.Map;

import DAO.CrewBoardDAO;
import DTO.CrewBoardDTO;

public class CrewBoardServiceImpl implements CrewBoardService{

	CrewBoardDAO dao;
	
	public CrewBoardServiceImpl() {
		this.dao = new CrewBoardDAO();
	}
	
	@Override
	public List<CrewBoardDTO> selectList(Map<String, String> map) {
		return dao.selectList(map);
	}

	@Override
	public int insertWrite(CrewBoardDTO dto) {
		return dao.insertWrite(dto);
	}
	
	@Override
	public int updateEdit(CrewBoardDTO dto) {
		return dao.updateEdit(dto); 
	}
	
	@Override
	public int deletePost(CrewBoardDTO dto) {
		// TODO Auto-generated method stub
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
	public CrewBoardDTO pnPage(String idx) {
		return dao.pnPage(idx);
	}

	@Override
	public List<String> selectCrewNames(String id) {
		return dao.selectCrewNames(id);
	}

	
}