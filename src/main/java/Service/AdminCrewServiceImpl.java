package Service;

import java.util.List;

import DAO.AdminCrewDAO;
import DTO.AdminCrewDTO;

public class AdminCrewServiceImpl implements AdminCrewService {
	
	AdminCrewDAO dao;

	public AdminCrewServiceImpl() {
		this.dao = new AdminCrewDAO();
	}
	
	public List<AdminCrewDTO> selectList() {
		return dao.selectList();
	}
	
	public int insertWrite(AdminCrewDTO dto) {
		return dao.insertWrite(dto);
	}
	
	public AdminCrewDTO selectView(int idx) {
		return this.dao.selectView(idx);
	}
	
	public int updateEdit(AdminCrewDTO dto) {
		return this.dao.updateEdit(dto);
	}
	
	public int delete(int idx) {
		return this.dao.delete(idx);
	}
	
}