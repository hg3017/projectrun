package Service;

import java.util.List;

import DAO.CommentDAO;
import DTO.CommentDTO;



// DAO 를 호출하기 위한 Service 객체입니다. LoginService 에서 상속받아 @Override 를 통해 구현합니다.
// Override : 부모 클래스의 동작 방법을 재정의 하여 선언합니다.

public class CommentServiceImpl implements CommentService {

	CommentDAO dao;
	
	public CommentServiceImpl() {
		this.dao = new CommentDAO();
	}

	
	@Override
	public List<CommentDTO> commentView(String board_type, String board_idx) {
		return dao.commentView(board_type, board_idx);
	}
	
	@Override
	public int insertComment(CommentDTO dto) {
		return dao.insertComment(dto);
	}
	
}
