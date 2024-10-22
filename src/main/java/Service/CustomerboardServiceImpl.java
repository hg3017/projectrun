package Service;

import java.util.List;
import java.util.Map;

import DAO.CustomerboardDAO;
import DTO.CustomerboardDTO;

public class CustomerboardServiceImpl implements CustomerboardService {

	CustomerboardDAO dao;
	
	public CustomerboardServiceImpl() {
		this.dao = new CustomerboardDAO();
	}

	@Override
	public List<CustomerboardDTO> selectList(Map<String, String> map) {
		return dao.selectList(map);
	}

//	@Override
//	public CustomerboardDTO selectView(String rum) {
//		return dao.selectView();
//	}

	@Override
	public int insertWrite(CustomerboardDTO dto) {
		return dao.inserWrite(dto);
	}

	@Override
	public int updateEdit(CustomerboardDTO dto) {
		return dao.updateEdit(dto);
	}

	@Override
	public int deletePost(CustomerboardDTO dto) {
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
