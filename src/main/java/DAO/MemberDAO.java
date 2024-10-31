package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
	
	// 검색 조건에 맞는 게시물의 개수를 반환합니다.
	public int selectCount(Map<String, String> map) {
		int totalCount = 0; // 결과(게시물 수)를 담을 변수

		// 게시물 수를 얻어오는 쿼리문 작성
		String query = "SELECT COUNT(*) FROM member";
		if (map != null && map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += " WHERE " + map.get("searchField") + " LIKE concat('%',?,'%') ";
		}

		try {
			psmt = con.prepareStatement(query); // 쿼리문 생성

			if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(1, "%" + map.get("searchWord") + "%");
			}

			rs = psmt.executeQuery(); // 쿼리 실행
			if (rs.next()) { // 커서를 첫 번째 행으로 이동
				totalCount = rs.getInt(1); // 첫 번째 칼럼 값을 가져옴
			}

		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		} 
		return totalCount;
	}
	
	public List<MemberDTO> selectList(Map<String, String> map){
		List<MemberDTO> mbt = new ArrayList<MemberDTO>();
		
		// String query = "select idx, id, pass, name, grade, nickname, location, phone_number, regidate, editdate, member_image_idx from member order by regidate desc";
		String query = "SELECT * FROM member";

		if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += " WHERE " + map.get("searchField") + " LIKE concat('%',?,'%')";
		}
		query += " ORDER BY idx DESC ";
		query += " LIMIT ? OFFSET ?";
		
		try {
			psmt = con.prepareStatement(query);
			int paramIndex = 1;
			if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(paramIndex++, map.get("searchWord"));

			}
			psmt.setInt(paramIndex++, Integer.parseInt(map.get("limit")));
			psmt.setInt(paramIndex, Integer.parseInt(map.get("offset")));

			rs = psmt.executeQuery(); // 쿼리 실행			
			while(rs.next()){
				MemberDTO dto = new MemberDTO();

				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id")); // 일련번호
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setGrade(rs.getInt("grade"));
				dto.setNickname(rs.getString("nickname"));
				dto.setLocation(rs.getString("location"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setRegidate(rs.getString("regidate"));
				dto.setEditdate(rs.getString("editdate"));
				dto.setMember_image_idx(rs.getInt("member_image_idx"));

				System.out.println(dto);
				
				mbt.add(dto);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("멤버 조회 중 예외 발생");
			e.printStackTrace();
		} 	
		
		// 목록 반환
		return mbt;
	}
	
	// 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
	public List<MemberDTO> selectListPage(Map<String, String> map) {
		List<MemberDTO> mbt = new Vector<MemberDTO>(); // 결과(게시물 목록)를 담을 변수

		// 쿼리문 템플릿
		String query = " SELECT * FROM member ";

		// 검색 조건 추가
		if (map.get("searchWord") != null) {
			query = " Where " + map.get("searchField") + " like concat('%',?,'%') ";
		}

		query += " ORDER BY idx DESC ";
		query += " LIMIT ? OFFSET ?";

		try {
			// 쿼리문 완성
			psmt = con.prepareStatement(query);

			// 쿼리문 실행
			rs = psmt.executeQuery();

			while (rs.next()) {
				// 한 행(게시물 하나)의 데이터를 DTO에 저장
				MemberDTO dto = new MemberDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id")); // 일련번호
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setGrade(rs.getInt("grade"));
				dto.setNickname(rs.getString("nickname"));
				dto.setLocation(rs.getString("location"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setRegidate(rs.getString("regidate"));
				dto.setEditdate(rs.getString("editdate"));
				dto.setMember_image_idx(rs.getInt("member_image_idx"));

				// 반환할 결과 목록에 게시물 추가
				mbt.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}

		// 목록 반환
		return mbt;
	}
	
	

	// 현재 사용 안하는 중
	public int insertWrite(String id, String pass, String name, int grade, String nickname, String location, String phone_number) {
		int rs = 0;

		// String sql = "insert into member(id,pass,name) values(?,?,?)";
		String sql = "insert into member(id,pass,name,grade,nickname,location,phone_number) values (?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			psmt.setString(3, name);
			grade = 01; // 테스트용 코드
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
		// insert into member(id,pass,name,grade,nickname,location,phone_number) values ('01','01','01',01,'01','01','01');
		// String sql = "insert into member(id,pass,name,grade,nickname,location,phone_number) values (?,?,?,?,?,?,?)";
		String sql = "insert into member(id,pass,name,grade,nickname,location,phone_number,description) values (?,?,?,?,?,?,?,?)";
		try {
			System.out.println("insertWrite 함수 실행 성공");
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			int number1 = 01;
			psmt.setInt(4, number1);
			// psmt.setInt(4, dto.getGrade());
			psmt.setString(5, dto.getNickname());
			psmt.setString(6, dto.getLocation());
			psmt.setString(7, dto.getPhone_number());
			psmt.setString(8, dto.getDescription());

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
		System.out.println("selectView 메서드의 id 값 : "+id);
		String sql = "select idx, id, pass, name, grade, nickname, location, phone_number, description, regidate, editdate, member_image_idx from member where id = ?";
		
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
				String description = rs.getString("description");
				String regidate = rs.getString("regidate");
				String editdate = rs.getString("editdate");
				int member_image_idx = rs.getInt("member_image_idx");
				//out.print(String.format("%s,%s,%s,%s <br>", id, pass, name, regidate));
				member = new MemberDTO(idx, id, pass, name, grade, nickname, location, phone_number, description, regidate, editdate, member_image_idx);
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
		String sql = "update member set pass= ?, name = ?, grade = ?, nickname= ?, location= ?, phone_number=?, description=?, member_image_idx=? where id = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getPass());
			psmt.setString(2, dto.getName());
			psmt.setInt(3, dto.getGrade());
			psmt.setString(4, dto.getNickname());
			psmt.setString(5, dto.getLocation());
			psmt.setString(6, dto.getPhone_number());
			psmt.setString(7, dto.getDescription());
			//psmt.setInt(8, dto.getMember_image_idx());
			int member_image_idx=0;
			psmt.setInt(8,member_image_idx);
			psmt.setString(9, dto.getId());

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
	
	public int selectCnt() {
	    int count = 0;

	    PreparedStatement pstmt = null;
	 
	    try {
			
	        StringBuffer sql = new StringBuffer();
	        sql.append("SELECT COUNT(id) FROM member");
	        pstmt = con.prepareStatement(sql.toString());
	        rs = pstmt.executeQuery();
	        int index = 0;
	        if (rs.next()) {
	            count = rs.getInt(++index);
	        }
	        System.out.println("member 개수 : "+count);
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null)
	                rs.close();
	            if (pstmt != null)
	                pstmt.close();
	            if (con != null)
	                con.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	    return count;
	}
	


}