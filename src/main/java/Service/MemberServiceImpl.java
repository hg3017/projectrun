package Service;

import java.util.List;

import DAO.MemberDAO;
import DTO.MemberDTO;

// MemberDAO.java DAO 클래스 import
// MemberDTO.jva DTO 클래스 import

public class MemberServiceImpl implements MemberService{
// 인터페이스를 구현하는 클래스이므로 추상 메서드 구현 안하면 오류 발생
	
	MemberDAO dao;
	// MemberDAO 클래스의 객체 dao를 선언한다.
	
	public MemberServiceImpl() {
		this.dao = new MemberDAO();
	}
	
	@Override
	public List<MemberDTO> selectList() {
		return dao.selectList();
		// dao 객체의 메서드 selectList()의 값을 반환한다.
	}
	
	@Override
	public int insertWrite(MemberDTO dto) {
		return dao.insertWrite(dto);
	}
	
	@Override
	public MemberDTO selectView(String id) {
		return this.dao.selectView(id);
	}
	@Override
	public int updateEdit(MemberDTO dto) {
		
		return this.dao.updateEdit(dto);
	}
	
	@Override
	public int delete(String id) {
		
		return this.dao.delete(id);
	}
}