package Service;

import java.util.List;

import DTO.AdminCrewDTO;


public interface AdminCrewService {

	public List<AdminCrewDTO> selectList();
	// selectList() 추상 메서드 선언, Member 테이블의 목록을 출력하는 메서드이다.
	public int insertWrite(AdminCrewDTO dto);
	// insertWrite() 추상 메서드 선언
	public AdminCrewDTO selectView(int idx);
	public int updateEdit(AdminCrewDTO dto);
	public int delete(int idx);
}