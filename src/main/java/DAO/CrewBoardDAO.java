package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Common.JDBConnect;
import DTO.CrewBoardDTO;
import DTO.FreeBoardDTO;


public class CrewBoardDAO extends JDBConnect{
	public CrewBoardDAO () {
		super();
	}
	
	public int selectCount(Map<String, String> map) {
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM crewboard";
		if(map.get("searchWord") != null) {
			query += "WHERE" +  map.get("searchField") + " "
					+  "LIKE '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}
		catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<CrewBoardDTO> selectList(Map<String, String> map) {
		List<CrewBoardDTO> cb = new ArrayList<CrewBoardDTO>();
		
		String query = "SELECT * FROM crewboard";
		if(map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += "WHERE" + map.get("searchField") + " LIKE concat('%',?,'%')";
		}
		query += "ORDER BY num DESC";
		query += "LIMIT ? OFFSET ?";
		
		try {
			psmt = con.prepareStatement(query.toString());

			if(map.get("searchWord") != null) {
				psmt.setString(1, map.get("searchWord"));
        		psmt.setInt(2, Integer.parseInt(map.get("limit")));
        		psmt.setInt(3, Integer.parseInt(map.get("offset")));
			}else {
				psmt.setInt(1, Integer.parseInt(map.get("limit")));
        		psmt.setInt(2, Integer.parseInt(map.get("offset")));  
			}
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CrewBoardDTO dto = new CrewBoardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setCrew_name(rs.getString("crew_name"));
				dto.setContent(rs.getString("content"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				cb.add(dto);
			}
		}catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return cb;
	}

	public List<CrewBoardDTO> selectListPage(Map<String, String> map) {
		List<CrewBoardDTO> cb = new Vector<CrewBoardDTO>(); // 결과(게시물 목록)를 담을 변수

		// 쿼리문 템플릿
		String query = " SELECT * FROM crewboard";

		// 검색 조건 추가
		if (map.get("searchWord") != null) {
			query = " Where " + map.get("searchField") + " like concat('%',?,'%') ";
		}

		query += " ORDER BY num DESC ";

		try {
			// 쿼리문 완성
			psmt = con.prepareStatement(query);

			// 쿼리문 실행
			rs = psmt.executeQuery();

			while (rs.next()) {
				// 한 행(게시물 하나)의 데이터를 DTO에 저장
				CrewBoardDTO dto = new CrewBoardDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setCrew_name(rs.getString("crew_name"));
				dto.setContent(rs.getString("content"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setVisitcount(rs.getString("visitcount"));

				// 반환할 결과 목록에 게시물 추가
				cb.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}

		// 목록 반환
		return cb;
	}
	
//	public List(CrewBoardDTO) selectListPage(Map<String,String>map){
//		List<CrewBoardDTO> cd = new Vector<CrewBoardDTO>();
//		
//		String query = "select * from crewboard";
//		
//		if(map.get("searchWord") != null) {
//			query = "where" + map.get("searchField") + "like concat('%',?,'%)";
//		}
//		query += "order by num desc";
//		
//		try {
//			psmt = con.prepareStatement(query);
//			
//			rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				CrewBoardDTO dto = new CrewBoardDTO();
//				dto.setIdx("num");
//				dto.setTitle("title");
//				dto.setContent("content");
//				dto.set("postdate");
//				dto.setIdx("id");
//			}
//		}catch{
//			
//		}
//	}
}
