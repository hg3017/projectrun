package member.service;

import java.util.List;

import member.dto.MemberDTO;


public interface MemberService {
	
	public List<MemberDTO> selectList();
	public MemberDTO selectView(String id);
	public int insertWrite(MemberDTO dto);
	public int updateEdit(MemberDTO dto);
}
