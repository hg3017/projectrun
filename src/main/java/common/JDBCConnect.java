package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBCConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBCConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/run";
			String user = "sub3";
			String pass = "project";
			
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB연결완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public JDBCConnect(String driver, String url, String user, String pass) {
		try{
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 성공(인수 생성자 1)");
		}catch(Exception e){
			e.printStackTrace();
		}
		close();
	}
	
	public JDBCConnect(ServletContext application) {
		try{
			String driver = application.getInitParameter("MysqlDriver");			
			
			Class.forName(driver);

			String url = application.getInitParameter("MysqlUrl");
			String user = application.getInitParameter("MysqlId");
			String pass = application.getInitParameter("MysqlPwd");

			con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 성공(인수 생성자 2)");
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
			System.out.println("JDBC 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
