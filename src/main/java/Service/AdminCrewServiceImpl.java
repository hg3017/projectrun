package Service;

import java.util.List;

import DAO.AdminCrewDAO;
import DTO.AdminCrewDTO;

// MemberDAO.java DAO 클래스 import
// MemberDTO.jva DTO 클래스 import

public class AdminCrewServiceImpl implements AdminCrewService{
// 인터페이스를 구현하는 클래스이므로 추상 메서드 구현 안하면 오류 발생
	
	AdminCrewDAO dao;
	// MemberDAO 클래스의 객체 dao를 선언한다.
	
	public AdminCrewServiceImpl() {
		this.dao = new AdminCrewDAO();
	}
	
	@Override
	public List<AdminCrewDTO> selectList() {
		return dao.selectList();
		// dao 객체의 메서드 selectList()의 값을 반환한다.
	}
	
	@Override
	public int insertWrite(AdminCrewDTO dto) {
		return dao.insertWrite(dto);
	}
	
	@Override
	public AdminCrewDTO selectView(int idx) {
		return this.dao.selectView(idx);
	}
	@Override
	public int updateEdit(AdminCrewDTO dto) {
		
		return this.dao.updateEdit(dto);
	}
	
	@Override
	public int delete(int idx) {
		
		return this.dao.delete(idx);
	}
}