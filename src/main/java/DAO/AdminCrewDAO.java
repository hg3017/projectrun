package DAO;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import Common.JDBConnect;
import DTO.AdminCrewDTO;

public class AdminCrewDAO extends JDBConnect{
	//DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// String dateTime = dateFormat.format(new Date());
	
	public AdminCrewDAO() {
		super();
	}

	// DB에서 crew 테이블의 데이터를 받아와 전부 출력하는 selectList() 메서드 선언
	public List<AdminCrewDTO> selectList() {
		System.out.println("selectList 메서드 실행 성공");
		List<AdminCrewDTO> crews = new ArrayList<>();
		// List형 객체 crews 선언, list의 요소는 AdminCrewDTO를 받아야된다.
		
		String sql = "select idx, name, location_id, description, regidate from crew order by regidate desc";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int idx = rs.getInt("idx");
				String name = rs.getString("name");
				String location_id = rs.getString("location_id");
				String description = rs.getString("description");
				String regidate = rs.getString("regidate");
				
				AdminCrewDTO dto = new AdminCrewDTO(idx, name, location_id, description, regidate);
				crews.add(dto);
				// crew 리스트에 dto를 요소로 추가한다.
				System.out.println(crews);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crews;
		// crews 리스트를 반환한다.
	}
	
	// DB 테이블에 데이터를 집어넣는 insertWrite 메서드 선언
	public int insertWrite(String name, String location_id, String description) {
	// 웹페이지 상에 입력한 데이터가 메서드 insertWrite의 인자로 사용된다.
		int rs = 0;
		
		String sql = "insert into crew(name,location_id,description,regidate) values(?,?,?,?)";
		// DB에 insert 문이 입력된다.
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, location_id);
			psmt.setString(3, description);
			String regidate = dateFormat.format(new Date());
			// 유저가 regidate 값을 입력하는 것이 아니라,
			// 현재 시간이 입력되므로 현재 시간값이 있는 dateTime 변수의 값이 regidate에 대입된다.
			psmt.setString(4, regidate);
			
			
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	// 오버라이딩된 insertWrite 메서드 선언, 매개변수로 dto 객체를 가진다.
	public int insertWrite(AdminCrewDTO dto) {
		int rs = 0;
		String sql = "insert into crew(name,location_id,description,regidate) values (?,?,?,?)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getLocation_id());
			psmt.setString(3, dto.getDescription());
			// psmt.setString(4, dto.getRegidate());
			String regidate = dateFormat.format(new Date());
			// 유저가 regidate 값을 입력하는 것이 아니라,
			// 현재 시간이 입력되므로 현재 시간값이 있는 dateTime 변수의 값이 regidate에 대입된다.
			psmt.setString(4, regidate);
			
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	// 선택된 idx의 정보만 보여주는 메서드 selectView 선언
	public AdminCrewDTO selectView(int idx) {
		AdminCrewDTO crew = null;
		String sql = "select idx, name, location_id, description, regidate from crew where idx = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, idx);
			rs = psmt.executeQuery();
			if (rs.next()) {
				idx = rs.getInt("idx");
				String name = rs.getString("name");
				String location_id = rs.getString("location_id");
				String description = rs.getString("description");
				String regidate = rs.getString("regidate");
				
				crew = new AdminCrewDTO(idx,name,location_id,description,regidate);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return crew;
		}
	
	// crew의 테이블의 특정 레코드의 데이터를 바꾸는 updateEdit() 메서드 선언
	public int updateEdit(AdminCrewDTO dto) {
		int rs = 0;

		String sql = "update crew set name=?,location_id=?,description=?where idx=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getLocation_id());
			psmt.setString(3, dto.getDescription());
			psmt.setInt(4, dto.getIdx());
			
			rs = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	// crew 테이블의 특정 레코드를 삭제하는 delete 메서드 선언
	public int delete(int idx) {
		int rs = 0;
		
		String sql = "delete from crew where idx =?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, idx);
			// 변수 idx 값이 sql문 ?에 들어간다.
			
			rs = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}


}