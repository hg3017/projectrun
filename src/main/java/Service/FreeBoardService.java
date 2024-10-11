package Service;

import java.util.List;

import DTO.FreeBoardDTO;


public interface FreeBoardService {
	
	public List<FreeBoardDTO> selectList();
	public FreeBoardDTO selectView(String num);
	public int insertWrite(FreeBoardDTO dto);
	public int updateEdit(FreeBoardDTO dto);
}
