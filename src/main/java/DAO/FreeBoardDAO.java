package DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Common.JDBConnect;
import DTO.FreeBoardDTO;

public class FreeBoardDAO extends JDBConnect {

	public FreeBoardDAO() {
	}

	// 검색 조건에 맞는 게시물의 개수를 반환합니다.
	public int selectCount(Map<String, String> map) {
		int totalCount = 0; // 결과(게시물 수)를 담을 변수

		// 게시물 수를 얻어오는 쿼리문 작성
		String query = "SELECT COUNT(*) FROM freeboard";
		if (map != null && map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += " WHERE " + map.get("searchField") + " LIKE concat('%',?,'%') ";
			// + " LIKE '%" + map.get("searchWord") + "%'";
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

	public List<FreeBoardDTO> selectList(Map<String, String> map) {
		List<FreeBoardDTO> fb = new ArrayList<FreeBoardDTO>();

		String query = "";
		query += "SELECT f.* ";
		query += "  FROM (";
		query += "		  SELECT @rownum:=@rownum+1 no";
		query += "			   , b.*";
		query += "			FROM FREEBOARD b";
		query += "		   WHERE (@rownum:=0)=0";
		
		if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += " 		 AND " + map.get("searchField") + " LIKE CONCAT('%',?,'%')";
		}
		
		query += "		 ) f";
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

			while (rs.next()) { // 결과를 순화하며...
				// 한 행(게시물 하나)의 내용을 DTO에 저장
				FreeBoardDTO dto = new FreeBoardDTO();

				dto.setIdx(rs.getString("idx")); // 일련번호
				dto.setTitle(rs.getString("title")); // 제목
				dto.setContent(rs.getString("content")); // 내용
				dto.setRegidate(rs.getDate("regidate")); // 작성일
				dto.setMember_id(rs.getString("member_id")); // 작성자 아이디
				dto.setVisitcount(rs.getString("visitcount")); // 조회수
				dto.setNo(rs.getInt("no"));
				
				fb.add(dto); // 결과 목록에 저장
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return fb;
	}

	// 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
	public List<FreeBoardDTO> selectListPage(Map<String, String> map) {
		List<FreeBoardDTO> fb = new Vector<FreeBoardDTO>(); // 결과(게시물 목록)를 담을 변수

		// 쿼리문 템플릿
		String query = " SELECT * FROM freeboard ";

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
				FreeBoardDTO dto = new FreeBoardDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegidate(rs.getDate("regidate"));
				dto.setMember_id(rs.getString("member_id"));
				dto.setVisitcount(rs.getString("visitcount"));

				// 반환할 결과 목록에 게시물 추가
				fb.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}

		// 목록 반환
		return fb;
	}

	// 게시글 데이터를 받아 DB에 추가합니다.
	public int insertWrite(FreeBoardDTO dto) {
		int result = 0;

		try {
			// INSERT 쿼리문 작성
			String query = "INSERT INTO freeboard (title,content,member_id,ofile,sfile) VALUES ( ?, ?, ?, ?, ?)";

			psmt = con.prepareStatement(query); // 동적 쿼리
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getMember_id());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());

			result = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}

		return result;
	}

	public FreeBoardDTO pnPage(String idx) {
		FreeBoardDTO dto = new FreeBoardDTO();
		
		String query = "";
		query += "SELECT F.*                                                  ";
		query += "  FROM (                                                    ";
		query += "		SELECT                                                ";
		query += "			IDX,                                              ";
		query += "			MEMBER_ID,                                        ";
		query += "			TITLE,                                            ";
		query += "			REGIDATE,                                         ";
		query += "			CONTENT,                                          ";
		query += "			OFILE,                                            ";
		query += "			SFILE,                                            ";
		query += "			LAG(IDX) OVER(ORDER BY IDX) AS PREV_NUM,          ";
		query += "			LEAD(IDX) OVER(ORDER BY IDX) AS NEXT_NUM,         ";
		query += "			LAG(TITLE) OVER(ORDER BY IDX) AS PREV_TITLE,      ";
		query += "			LEAD(TITLE) OVER(ORDER BY IDX) AS NEXT_TITLE      ";
		query += "		FROM FREEBOARD                                        ";
		query += "	) F                                                       ";
		query += " WHERE IDX = ?                                              ";
		
		try {
			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				// 현재 게시글 정보
				dto.setMember_id(rs.getString("member_id"));
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setOfile(rs.getString("ofile"));
				dto.setSfile(rs.getString("sfile"));
				dto.setRegidate(rs.getDate("regidate"));
				
				// 이전글 정보
				dto.setPrevNum(rs.getString("prev_num"));
				dto.setPrevTitle(rs.getString("prev_title"));
				
				// 다음글 정보
				dto.setNextNum(rs.getString("next_num"));
				dto.setNextTitle(rs.getString("next_title"));
			}
			// 쿼리문 실행
			
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return dto; // 결과 반환
	}
	public void updateVisitCount(String idx) {
		// 쿼리문 준비
		String query = "UPDATE freeboard SET visitcount=visitcount+1 WHERE idx=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx); // 인파라미터를 일련번호로 설정
			psmt.executeUpdate(); // 쿼리 실행
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}
	// 지정한 게시물을 수정합니다.
	public int updateEdit(FreeBoardDTO dto, String path) {
		int result = 0;

		try {
			String selectQuery = "SELECT sfile FROM freeboard WHERE idx=?";
	        psmt = con.prepareStatement(selectQuery);
	        psmt.setString(1, dto.getIdx());
	        rs = psmt.executeQuery();

	        // 2. 새로운 파일이 업로드되었는지 확인 후 기존 파일 삭제
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
			// 쿼리문 템플릿
			String query = "UPDATE freeboard SET title=?, content=? ";
			if(dto.getOfile() != null) {
				query += ", ofile=?, sfile=? ";
			}
			query += "WHERE idx=?";

			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			if(dto.getOfile() != null) {
				
				psmt.setString(1, dto.getTitle());
				psmt.setString(2, dto.getContent());
				psmt.setString(3, dto.getOfile());
				psmt.setString(4, dto.getSfile());
				psmt.setString(5, dto.getIdx());
			} else {
				psmt.setString(1, dto.getTitle());
				psmt.setString(2, dto.getContent());
				psmt.setString(3, dto.getIdx());
			}

			// 쿼리문 실행
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}

		return result; // 결과 반환
	}

	// 지정한 게시물을 삭제합니다.
	public int deletePost(String idx) {
		int result = 0;

		try {
			// 쿼리문 템플릿
			String query = "DELETE FROM freeboard WHERE idx=?";

			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);

			// 쿼리문 실행
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}

		return result; // 결과 반환
	}

}
