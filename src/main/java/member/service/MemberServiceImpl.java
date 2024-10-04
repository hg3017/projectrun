package member.service;

import java.util.List;

import member.dao.MemberDAO;
import member.dto.MemberDTO;


public class MemberServiceImpl implements MemberService{
	
	MemberDAO dao;
	
	public MemberServiceImpl() {
		this.dao = new MemberDAO();
	}

	@Override
	public List<MemberDTO> selectList() {
		
		return dao.selectList();
	}

	@Override
	public int insertWrite(MemberDTO dto) {
		return dao.insertWrite(dto);
	}

	@Override
	public MemberDTO selectView(String id) {
		
		return dao.selectView(id);
	}

	@Override
	public int updateEdit(MemberDTO dto) {
		
		return dao.updateEdit(dto);
	}


}
