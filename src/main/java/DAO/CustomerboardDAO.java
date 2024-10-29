package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Common.JDBConnect;
import DTO.CustomerboardDTO;

public class CustomerboardDAO extends JDBConnect {
	public CustomerboardDAO() {
	}
	
	public int selectCount(Map<String, String> map) {
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM customerboard";
		if(map !=null && map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += " WHERE " + map.get("searchField") + " LIKE ?";
		}
		
		try {
			psmt = con.prepareStatement(query);
			
			if(map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(1, "%" + map.get("searchWord") + "%");
			}
			
			rs = psmt.executeQuery(query);
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		}catch (Exception e){
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		
		return totalCount;
		
	}
	
	public List<CustomerboardDTO> selectList(Map<String, String> map) {
		List<CustomerboardDTO> cs = new ArrayList<CustomerboardDTO>();
		
		String query = "SELECT * FROM customerboard";
		if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += " WHERE " + map.get("searchField") + " LIKE concat('%',?,'%')";
		}
		query += " ORDER BY idx DESC ";
		query += " LIMIT ? OFFSET ? ";
		
		try {
			psmt = con.prepareStatement(query.toString());
			
			int paramIndex = 1;
			if (map.get("serarchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(paramIndex++, map.get("searchWord"));
			}else {
				psmt.setInt(paramIndex++, Integer.parseInt(map.get("limit")));
				psmt.setInt(paramIndex, Integer.parseInt(map.get("offset")));
			}
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				CustomerboardDTO dto = new CustomerboardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setCategory(rs.getString("category"));
				dto.setAbleview(rs.getString("ableview"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setRegidate(rs.getDate("regidate"));
				dto.setVisitcount(rs.getInt("visitcount"));
				
				cs.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return cs;
	}
	
	public List<CustomerboardDTO> selectListPage(Map<String, String> map) {
		List<CustomerboardDTO> cs = new Vector<CustomerboardDTO>();
		
		String query = " SELECT * FROM customerboard ";
		
		if (map.get("serarchWord") !=null) {
			query = " Where " + map.get("searchField") + " like contcat('%',?,'%')";
		}
		query += " ORDER BY idex DESC ";
		query += " LIMIT ? OFFSET ?";
		
		try {
			psmt = con.prepareStatement(query);
			int paramIndex = 1;
			if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(paramIndex++, map.get("searchWord"));

			}
			psmt.setInt(paramIndex++, Integer.parseInt(map.get("limit")));
			psmt.setInt(paramIndex, Integer.parseInt(map.get("offset")));
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CustomerboardDTO dto = new CustomerboardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setCategory(rs.getString("category"));
				dto.setAbleview(rs.getString("ableview"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setRegidate(rs.getDate("regidate"));
				dto.setVisitcount(rs.getInt("visitcount"));
				
				cs.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		
		return cs;
	
	}
	
	public CustomerboardDTO viewPage(String idx) {
		CustomerboardDTO dto = new CustomerboardDTO();
		
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
		query += " WHERE IDX = ?                                            ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
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
				
			}
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
		
	}
	
	public int insertWrite(CustomerboardDTO dto) {
		int result = 0;
		
		try {
			String query = "INSERT INTO customerboard (category,ableview,title,member_id,content) VALUES (?, ?, ?, ?, ?)";
			
//			System.out.println("DAO에서 ableview 확인 : "+dto.getAbleview());
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getCategory());
			psmt.setString(2, "공개");
			// psmt.setString(2, dto.getAbleview());
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getMember_id());
			psmt.setString(5, dto.getContent());
			
			result = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateVisitCount(String idx) {
		String query = "UPDATE customerboard SET visitcount=visitcount+1 WHERE idx=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외발생");
			e.printStackTrace();
		}
	}
	
	public int updateEdit(CustomerboardDTO dto) {
		int result = 0;
		
		try {
			String query = " UPDATE customerboard SET " + " category=?, ableview=?, title=?, content=? " + " WHERE idx=? ";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getCategory());
			psmt.setString(2, "공개");
			psmt.setString(3, dto.getTitle());
			psmt.setString(4, dto.getContent());
			psmt.setString(5, dto.getIdx());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public int deletePost(CustomerboardDTO dto) {
		int result = 0;
		
		try {
			String query = "DELETE FROM customerboard WHERE idx=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getIdx());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
}
