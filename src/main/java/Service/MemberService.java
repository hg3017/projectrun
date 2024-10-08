package Service;

import java.util.List;

import DTO.MemberDTO;


public interface MemberService {

	public List<MemberDTO> selectList();
	// selectList() 추상 메서드 선언, Member 테이블의 목록을 출력하는 메서드이다.
	public int insertWrite(MemberDTO dto);
	// insertWrite() 추상 메서드 선언
	public MemberDTO selectView(String id);
	public int updateEdit(MemberDTO dto);
	public int delete(String id);
}