package Service;

import java.util.List;

import DTO.AdminCrewDTO;

public interface AdminCrewService {

	public List<AdminCrewDTO> selectList();
	public int insertWrite(AdminCrewDTO dto);
	// insertWrite() 추상 메서드 선언
	public AdminCrewDTO selectView(int idx);
	public int updateEdit(AdminCrewDTO dto);
	public int delete(int idx);
}
