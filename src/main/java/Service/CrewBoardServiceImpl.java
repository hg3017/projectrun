package Service;

import java.util.List;
import java.util.Map;

import DAO.CrewBoardDAO;
import DAO.FreeBoardDAO;
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
	public int selectCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.selectCount(map);
	}
	
	
}
