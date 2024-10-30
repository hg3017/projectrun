package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Common.DBConnectionPool;
import Common.JDBConnect;
import DTO.CustomerboardDTO;
import DTO.LoginDTO;

public class LoginDAO {
	
	 private DBConnectionPool dbConnectionPool;

    // DBConnectionPool 인스턴스를 생성자로 전달
    public LoginDAO(DBConnectionPool dbConnectionPool) {
        this.dbConnectionPool = dbConnectionPool;
    }

    public LoginDTO selectView(String id) {
        LoginDTO member = null;
        Connection con = null;
        
        String sql = "SELECT id, pass FROM member WHERE id = ?";

        try {
            // DBConnectionPool에서 Connection 가져오기
            con = dbConnectionPool.getConnection();
            var psmt = con.prepareStatement(sql);
            psmt.setString(1, id);
            var rs = psmt.executeQuery();

            // 쿼리 결과 처리
            if (rs.next()) {
                String pass = rs.getString("pass");
                member = new LoginDTO(id, pass);
            }
            psmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Connection을 풀에 반환
            if (con != null) {
                dbConnectionPool.releaseConnection(con);
            }
        }
        return member;
    }

	public List<CustomerboardDTO> ViewPage() {
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<CustomerboardDTO> list = new ArrayList<>();
		
		String query = "";
		query += " SELECT CS.*												";
		query += "	FROM (													";
		query += " 		SELECT												";
		query += " 			IDX, 											";
		query += " 			CATEGORY, 										";
		query += " 			ABLEVIEW, 										";
		query += " 			TITLE,											";
		query += " 			MEMBER_ID,										";
		query += " 			CONTENT, 										";
		query += " 			REGIDATE,										";
		query += " 			VISITCOUNT, 									";
		query += "			LAG(IDX) OVER(ORDER BY IDX) AS PREVNUM,       	";
		query += "			LEAD(IDX) OVER(ORDER BY IDX) AS NEXTNUM,       	";
		query += "			LAG(TITLE) OVER(ORDER BY IDX) AS PREVTITLE,    	";
		query += "			LEAD(TITLE) OVER(ORDER BY IDX) AS NEXTTITLE    	";
		query += " 		FROM CUSTOMERBOARD 									";
		query += " 	) CS 													";
		query += "ORDER BY REGIDATE DESC 	 								";
		query += " LIMIT 0, 3 		                                        ";
		
		try {
			con = dbConnectionPool.getConnection();
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				CustomerboardDTO dto = new CustomerboardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setCategory(rs.getString("category"));
				dto.setAbleview(rs.getString("ableview"));
				dto.setTitle(rs.getString("title"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setContent(rs.getString("content"));
				dto.setRegidate(rs.getDate("regidate"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setPrevnum(rs.getString("prevnum"));
				dto.setPrevtitle(rs.getString("prevtitle"));
				dto.setNextnum(rs.getString("nextnum"));
				dto.setNexttitle(rs.getString("nexttitle"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return list;
	}
	    
}
