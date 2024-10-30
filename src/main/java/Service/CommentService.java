package Service;

import java.util.List;

import DTO.CommentDTO;


public interface CommentService {
	
	// DAO 를 호출하기 위한 Service 객체입니다. interface 를 통해 미리 정의합니다.
	public List<CommentDTO> commentView(String board_type, String boardIdx);
	
	public int insertComment(CommentDTO dto);
	
}
