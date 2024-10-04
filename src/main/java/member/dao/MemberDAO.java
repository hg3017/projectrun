package member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import common.JDBCConnect;
import member.dto.MemberDTO;

public class MemberDAO extends JDBCConnect{
	
	public MemberDAO(ServletContext application) {
		super(application);
	}
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public List<MemberDTO> selectList(){
		List<MemberDTO> members = new ArrayList<>();
		
		String sql = "select id, pass, name, regidate from member order by regidate desc";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);	
			
			while(rs.next()){
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String regidate = rs.getString("regidate");
				//out.print(String.format("%s,%s,%s,%s <br>", id, pass, name, regidate));
				MemberDTO dto = new MemberDTO(id, pass, name, regidate);
				members.add(dto);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
		return members;
	}

	public int insertWrite(String id, String pass, String name) {
		int rs = 0;

		String sql = "insert into member(id,pass,name) values(?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			psmt.setString(3, name);

			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}

	public int insertWrite(MemberDTO dto) {
		int rs = 0;

		String sql = "insert into member(id,pass,name) values(?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());

			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}

	public MemberDTO selectView(String id) {
		MemberDTO member = null;
		String sql = "select id, pass, name, regidate from member where id = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();			
			if (rs.next()) {
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String regidate = rs.getString("regidate");
				member = new MemberDTO(id, pass, name, regidate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;			
	}

	public int updateEdit(MemberDTO dto) {
		int rs = 0;

		String sql = "update member set pass = ?, name = ? where id = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getId());

			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}
	
	public int deletePcs(String id) {
		int rs = 0;

		String sql = "delete from member where id = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return rs;
	}

}
