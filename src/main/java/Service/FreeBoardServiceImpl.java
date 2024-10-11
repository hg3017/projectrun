package Service;

import java.util.List;

import DAO.FreeBoardDAO;
import DTO.FreeBoardDTO;



public class FreeBoardServiceImpl implements FreeBoardService{
	
	FreeBoardDAO dao;
	
	public FreeBoardServiceImpl() {
		this.dao = new FreeBoardDAO();
	}

	@Override
	public List<FreeBoardDTO> selectList() {
		
		return dao.selectList(null);
	}

	@Override
	public int insertWrite(FreeBoardDTO dto) {
		return dao.insertWrite(dto);
	}

	@Override
	public FreeBoardDTO selectView(String num) {
		
		return dao.selectView(num);
	}

	@Override
	public int updateEdit(FreeBoardDTO dto) {
		
		return dao.updateEdit(dto);
	}


}
