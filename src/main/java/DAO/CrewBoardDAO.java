package DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Common.JDBConnect;
import DTO.CrewBoardDTO;


public class CrewBoardDAO extends JDBConnect{
	public CrewBoardDAO () {
	}
	
	public int selectCount(Map<String, String> map) {
		int totalCount = 0;
		
		String query = "SELECT COUNT(*) FROM crewboard";
		if(map !=null && map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			  query += " WHERE " + map.get("searchField") + " LIKE concat('%',?,'%')";
		}
		try {
			psmt = con.prepareStatement(query);
			
			if(map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(1, "%" + map.get("searchWord") + "%");
			}
			
			rs = psmt.executeQuery();
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
			  query += " WHERE " + map.get("searchField") + " LIKE concat('%',?,'%')";
	      
		}
		query += " ORDER BY idx DESC ";
		 query += " LIMIT ? OFFSET ? ";
		
		try {
			psmt = con.prepareStatement(query);
			
			int paramIndex = 1;
			if(map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(paramIndex++, map.get("searchWord"));
			}
				psmt.setInt(paramIndex++, Integer.parseInt(map.get("limit")));
        		psmt.setInt(paramIndex, Integer.parseInt(map.get("offset")));  
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CrewBoardDTO dto = new CrewBoardDTO();
				
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setCrew_name(rs.getString("crew_name"));
				dto.setContent(rs.getString("content"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setRegidate(rs.getDate("regidate"));
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
		String query = " SELECT * FROM crewboard ";

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
				CrewBoardDTO dto = new CrewBoardDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setCrew_name(rs.getString("crew_name"));
				dto.setContent(rs.getString("content"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setRegidate(rs.getDate("regidate"));
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
	
	public int insertWrite(CrewBoardDTO dto) { 
		int result = 0;
		
		try {

			String query = "INSERT INTO crewboard (title, crew_name, content, member_id, ofile, sfile) VALUES (?, ?, ?, ?, ? ,?)";

			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getCrew_name());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getMember_id());
			psmt.setString(5, dto.getOfile());
			psmt.setString(6, dto.getSfile());
			
			result = psmt.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public CrewBoardDTO pnPage(String idx) {
		CrewBoardDTO dto = new CrewBoardDTO();
		
		String query = "";
		
		query += "SELECT CB.*                                                  ";
		query += "  FROM (                                                    ";
		query += "		SELECT                                                ";
		query += "			IDX,                                              ";
		query += "			TITLE,                                            ";
		query += "			MEMBER_ID,                                         ";
		query += "			CREW_NAME,                                         ";
		query += "			CONTENT,                                          ";
		query += "			REGIDATE,                                         ";
		query += "			OFILE,                                         ";
		query += "			SFILE,                                         ";
		query += "			LAG(IDX) OVER(ORDER BY IDX) AS PREVNUM,          ";
		query += "			LEAD(IDX) OVER(ORDER BY IDX) AS NEXTNUM,         ";
		query += "			LAG(TITLE) OVER(ORDER BY IDX) AS PREVTITLE,      ";
		query += "			LEAD(TITLE) OVER(ORDER BY IDX) AS NEXTTITLE      ";
		query += "		FROM CREWBOARD                                        ";
		query += "	) CB                                                       ";
		query += " WHERE IDX = ?                                              ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setMember_id(rs.getString("member_id"));
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setCrew_name(rs.getString("crew_name"));
				dto.setContent(rs.getString("content"));
				dto.setRegidate(rs.getDate("regidate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				
				dto.setPrevnum(rs.getString("prevnum"));
				dto.setPrevtitle(rs.getString("prevtitle"));
				
				dto.setNextnum(rs.getString("nextnum"));
				dto.setNexttitle(rs.getString("nexttitle"));
				
			}
		}
		catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}

	public void updateVisitCount(String idx) {
		
		String query = "UPDATE crewboard SET visitcount=visitcount +1 WHERE idx=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1,idx);
			psmt.executeUpdate(); 
		}catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
		
	}

	public int updateEdit(CrewBoardDTO dto, String path) {
		int result = 0;
		
		try {
			String selectQuery = "SELECT sfile FROM crewboard WHERE idx=?";
			psmt = con.prepareStatement(selectQuery);
			psmt.setString(1, dto.getIdx());
			rs = psmt.executeQuery();
			
			
			if(rs.next()) {
	        	if (dto.getSfile() != null && !dto.getSfile().isEmpty() && path != null) {
	        		File oldFile = new File(path + File.separator + rs.getString(1));
	        		if (oldFile.exists()) {
	        			boolean deleted = oldFile.delete();
	        			System.out.println("파일 삭제 여부: " + deleted);
	        			if (!deleted) {
	        				System.out.println("파일 삭제 실패 - 경로: " + path);
	        			}
	        		} else {
	        			System.out.println("삭제할 파일이 존재하지 않습니다 - 경로: " + path);
	        		}
	        	}
	        	
	        }
	
			String query = "UPDATE crewboard SET title=?, content=?, ofile=?, sfile=? WHERE idx=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			psmt.setString(5, dto.getIdx());
			
			result = psmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public int deletePost(CrewBoardDTO dto) {
		
		int result = 0;
		
		try {
			String query = "DELETE FROM crewboard WHERE idx=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getIdx());
			
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<String> selectCrewNames(String id) {
		List<String> list = new ArrayList<>();
		
		try {
			String query = "SELECT CREW_NAME FROM CREW_MEMBER WHERE MEMBER_ID = ?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}