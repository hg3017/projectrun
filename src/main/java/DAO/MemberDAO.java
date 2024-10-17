package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import Common.JDBConnect;
import DTO.MemberDTO;

public class MemberDAO extends JDBConnect{
	
	public MemberDAO() {
		super();
	}
	
	public List<MemberDTO> selectList(){
		List<MemberDTO> members = new ArrayList<>();
		
		String sql = "select idx, id, pass, name, grade, nickname, location, phone_number, regidate, editdate, member_image_idx from member order by regidate desc";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int idx = rs.getInt("idx");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				// member 테이블에서 grade 컬럼을 설계할 때 int형 사용했으므로
				// dao에서도 int형 사용해서 변수 선언
				String nickname = rs.getString("nickname");
				String location = rs.getString("location");
				String phone_number = rs.getString("phone_number");
				String regidate = rs.getString("regidate");
				String editdate = rs.getString("editdate");
				int member_image_idx = rs.getInt("member_image_idx");
				//out.print(String.format("%s,%s,%s,%s <br>", id, pass, name, regidate));
				MemberDTO dto = new MemberDTO(idx, id, pass, name, grade, nickname, location, phone_number, regidate, editdate, member_image_idx);
				members.add(dto);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
		return members;
	}

	public int insertWrite(String id, String pass, String name, int grade, String nickname, String location, String phone_number) {
		int rs = 0;

		// String sql = "insert into member(id,pass,name) values(?,?,?)";
		String sql = "insert into member(id,pass,name,grade,nickname,location,phone_number) values (?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			psmt.setString(3, name);
			grade = 1; // 테스트용 코드
			psmt.setInt(4, grade);
			psmt.setString(5, nickname);
			psmt.setString(6, location);
			psmt.setString(7, phone_number);

			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			// close() 다 빼기
			// finally { close(); }
		return rs;
	}

	public int insertWrite(MemberDTO dto) {
		int rs = 0;

		String sql = "insert into member(id,pass,name,grade,nickname,location,phone_number) values (?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			dto.setGrade(1); // 테스트용 코드
			psmt.setInt(4, dto.getGrade());
			psmt.setString(5, dto.getNickname());
			psmt.setString(6, dto.getLocation());
			psmt.setString(7, dto.getPhone_number());

			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// close() 빼기
		// finally { close(); }

		return rs;
	}

	public MemberDTO selectView(String id) {
		System.out.println("selectView 동작 성공");
		MemberDTO member = null;
		// String sql = "select id, pass, name, regidate from member where id = ?";
		String sql = "select idx, id, pass, name, grade, nickname, location, phone_number, regidate, editdate from member where id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			// id 값 설정
			rs = psmt.executeQuery();
			if (rs.next()) {
				// String id2 = id; //  테스트용 코드
				int idx = rs.getInt("idx");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				// member 테이블에서 grade 컬럼을 설계할 때 int형 사용했으므로
				// dao에서도 int형 사용해서 변수 선언
				String nickname = rs.getString("nickname");
				String location = rs.getString("location");
				String phone_number = rs.getString("phone_number");
				String regidate = rs.getString("regidate");
				String editdate = rs.getString("editdate");
				int member_image_idx = rs.getInt("member_image_idx");
				//out.print(String.format("%s,%s,%s,%s <br>", id, pass, name, regidate));
				member = new MemberDTO(idx, pass, name, grade, nickname, location, phone_number, regidate, editdate, member_image_idx);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// finally { close(); }
		return member;
	}

	public int updateEdit(MemberDTO dto) {
		int rs = 0;
		
		// String sql = "update member set pass = ?, name = ? where id = ?";
		String sql = "update member set pass= ?, name = ?, nickname= ?, location= ?, phone_number=?  where id = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getNickname());
			psmt.setString(4, dto.getLocation());
			psmt.setString(5, dto.getPhone_number());
			psmt.setString(6, dto.getId());

			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// finally { close(); }
		return rs;
	}
	
	public int delete(String id) {
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
		// finally { close(); }		
		return rs;
	}

}