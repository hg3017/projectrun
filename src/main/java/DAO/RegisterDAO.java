package DAO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.JDBConnect;
import DTO.RegisterDTO;

public class RegisterDAO extends JDBConnect { 
	
	public int insertMember(RegisterDTO dto) {
		
		int rs = 0;
		String sql = "insert into member(id,pass,name,grade,nickname,location,phone_number) values (?,?,?,?,?,?,?)";
		
		try {
			// JDBConnect 에서 상속받은 psmt 객체를 통해 jdbc 에 쿼리를 요청합니다. 
			// 미리 정의한 문자열 sql 의 ? 의 자리에 id 값을 입력하고 쿼리를 작동합니다. 
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setInt(4, dto.getGrade());
			psmt.setString(5, dto.getNickname());
			psmt.setInt(6, dto.getLocation());
			psmt.setInt(7, dto.getPhone_number());
			
			// 결과값이 있는 경우 1을 리턴하여 rs 의 값을1로 변경합니다. 
			rs = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// 예외 발생시 에러메시지를 출력합니다. 
			e.printStackTrace();
		} finally {
			// 작업이 종료된 후 dbconn 을 종료합니다.
			close();
		}
		
		return rs;			
	}

}

	