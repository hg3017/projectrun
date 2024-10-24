package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.JDBConnect;
import DTO.CommentDTO;
import DTO.CrewBoardDTO;
import DTO.LocationDTO;
import DTO.LoginDTO;
import DTO.RegisterDTO;

public class CommentDAO extends JDBConnect {
		
	// 로그인 할 때, 사용자가 있는지 확인하는 메서드입니다. LoginDTO 객체를 리턴합니다. 
	public List<CommentDTO> commentView(String crew_name) {
		List<CommentDTO> comment = new ArrayList<CommentDTO>();
		
		String sql = "select member_id, content, regidate from crewcomment where crew_name = ? ";
		try {
			// JDBConnect 에서 상속받은 psmt 객체를 통해 jdbc 에 쿼리를 요청합니다. 
			// 미리 정의한 문자열 sql 의 ? 의 자리에 id 값을 입력하고 쿼리를 작동합니다. 
			psmt = con.prepareStatement(sql);
			psmt.setString(1, crew_name);
			rs = psmt.executeQuery();
			
			// 쿼리의 결과값이 있는 경우 쿼리의 결과 컬럼 pass 값을 String 형으로 선언한  pass 에 입력합니다. 
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				
				dto.setMember_id(rs.getString("member_id"));
				dto.setContent(rs.getString("content"));
				dto.setRegidate(rs.getDate("regidate"));
				
				comment.add(dto);
				
			}
		} catch (SQLException e) {
			// 예외 발생시 에러메시지를 출력합니다. 
			e.printStackTrace();
		} finally {
			// 작업이 종료된 후 dbconn 을 종료합니다.
//			close();
		}
		
		return comment;			
	}
	
	
	public int insertComment (CommentDTO dto) {
		
		int rs = 0;
		String sql = "insert into crewcomment(member_id, content, crew_name) values (?,?,?)";
		
		try {
			// JDBConnect 에서 상속받은 psmt 객체를 통해 jdbc 에 쿼리를 요청합니다. 
			// 미리 정의한 문자열 sql 의 ? 의 자리에 id 값을 입력하고 쿼리를 작동합니다. 
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getMember_id());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getCrew_name());
			
			// 결과값이 있는 경우 1을 리턴하여 rs 의 값을1로 변경합니다. 
			rs = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// 예외 발생시 에러메시지를 출력합니다. 
			e.printStackTrace();
		} finally {
			// 작업이 종료된 후 dbconn 을 종료합니다.
			//close();
		}
		
		return rs;			
	}
	
	
}
