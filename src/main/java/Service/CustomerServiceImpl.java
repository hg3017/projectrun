package Service;

import java.util.List;
import java.util.Map;

import DAO.FreeBoardDAO;
import DTO.FreeBoardDTO;

public class CustomerServiceImpl implements CustomerService {

	FreeBoardDAO dao;
	
	public CustomerServiceImpl() {
		this.dao = new FreeBoardDAO();
	}

	@Override
	public List<FreeBoardDTO> selectList(Map<String, String> map) {
		return dao.selectList(map);
	}

	@Override
	public FreeBoardDTO selectView(String rum) {
		return dao.selectView(rum);
	}

	@Override
	public int insertWrite(FreeBoardDTO dto) {
		return dao.insertWrite(dto);
	}

	@Override
	public int updateEdit(FreeBoardDTO dto) {
		return dao.updateEdit(dto);
	}

	@Override
	public int deletePost(FreeBoardDTO dto) {
		return dao.deletePost(dto);
	}
	
}
