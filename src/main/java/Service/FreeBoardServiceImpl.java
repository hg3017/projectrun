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
	public FreeBoardDTO selectView(String num) {
		
		return dao.selectView(num);
	}

	@Override
	public int updateEdit(FreeBoardDTO dto) {
		
		return dao.updateEdit(dto);
	}

	@Override
	public int deletePost(FreeBoardDTO dto) {
		// TODO Auto-generated method stub
		return dao.deletePost(dto);
	}


}
