package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.DBConnectionPool;
import Common.JDBConnect;
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
	        
	        System.out.println("LoginDAO-selectView");
	        
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
}
