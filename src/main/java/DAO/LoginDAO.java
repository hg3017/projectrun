package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.JDBConnect;
import DTO.LoginDTO;

public class LoginDAO extends JDBConnect {
		
	// 로그인 할 때, 사용자가 있는지 확인하는 메서드입니다. LoginDTO 객체를 리턴합니다. 
	public LoginDTO selectView(String id) {
		LoginDTO member = null;
		
		String sql = "select id, pass from member where id = ?";
		try {
			// JDBConnect 에서 상속받은 psmt 객체를 통해 jdbc 에 쿼리를 요청합니다. 
			// 미리 정의한 문자열 sql 의 ? 의 자리에 id 값을 입력하고 쿼리를 작동합니다. 
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			// 쿼리의 결과값이 있는 경우 쿼리의 결과 컬럼 pass 값을 String 형으로 선언한  pass 에 입력합니다. 
			if (rs.next()) {
				String pass = rs.getString("pass");
				// LoginDTO 객체를 id, pass 값을 넣어서 생성합니다. 
				member = new LoginDTO(id, pass);
			}
		} catch (SQLException e) {
			// 예외 발생시 에러메시지를 출력합니다. 
			e.printStackTrace();
		} finally {
			// 작업이 종료된 후 dbconn 을 종료합니다.
//			close();
		}
		
		return member;			
	}
	
	
}
