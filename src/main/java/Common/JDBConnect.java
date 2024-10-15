package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBConnect {

	// JDBC API에서 데이터베이스와 연결을 관리하는 인터페이스입니다. 
	public Connection con;
	
	// JDBC를 통해 SQL 쿼리를 실행하는 인터페이스입니다. 
	public Statement stmt;
	
	// JDBC(Java Database Connectivity) API에서 SQL문을 미리 컴파일하여 실행하는 객체 입니다. 
	public PreparedStatement psmt;
	
	// JDBC(Java Database Connectivity) API에서 데이터베이스 쿼리 결과를 표 형태로 반환하는 객체입니다. 
	public ResultSet rs;

	// 미리 설정한 경로와 JDBC Connection 을 수행하는 메서드입니다. 
	public JDBConnect() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			// sys: 접근하려는 db Connection Name
			// user : 접근하려는 db 유저명
			// pass : 접근하려는 db Connection password 
			String url = "jdbc:mysql://localhost:3306/run";
			String user = "sub3";
			String pass = "project";
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 성공(기본 생성자)");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void close()
	{	
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			System.out.println("JDBC 자원 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
}