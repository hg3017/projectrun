package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import Common.JDBConnect;
import DTO.AnnouncementDTO;

public class AnnouncementDAO extends JDBConnect {

	public AnnouncementDAO() {
		// TODO Auto-generated constructor stub
	}

	// 검색 조건에 맞는 게시물의 개수를 반환합니다.
	public int selectCount(Map<String, String> map) {
		int totalCount = 0; // 결과(게시물 수)를 담을 변수

		// 게시물 수를 얻어오는 쿼리문 작성
		String query = "SELECT COUNT(*) FROM announcement";
		if (map != null && map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += " WHERE " + map.get("searchField") + " LIKE ? ";
			// + " LIKE '%" + map.get("searchWord") + "%'";
		}

		try {
			psmt = con.prepareStatement(query); // 쿼리문 생성

			if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(1, "%" + map.get("searchWord") + "%");
			}

			rs = psmt.executeQuery(query); // 쿼리 실행
			if (rs.next()) { // 커서를 첫 번째 행으로 이동
				totalCount = rs.getInt(1); // 첫 번째 칼럼 값을 가져옴
			}

		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}

		return totalCount;
	}

	public List<AnnouncementDTO> selectList(Map<String, String> map) {
		List<AnnouncementDTO> amt = new ArrayList<AnnouncementDTO>();

		String query = "SELECT * FROM announcement";
		if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
			query += " WHERE " + map.get("searchField") + " LIKE concat('%',?,'%')";
		}
		query += " ORDER BY num DESC ";
		query += " LIMIT ? OFFSET ?";

		try {
			psmt = con.prepareStatement(query.toString());
			int paramIndex = 1;
			if (map.get("searchWord") != null && !map.get("searchWord").isEmpty()) {
				psmt.setString(paramIndex++, map.get("searchWord"));

			}
			psmt.setInt(paramIndex++, Integer.parseInt(map.get("limit")));
			psmt.setInt(paramIndex, Integer.parseInt(map.get("offset")));

			rs = psmt.executeQuery(); // 쿼리 실행

			while (rs.next()) { // 결과를 순화하며...
				// 한 행(게시물 하나)의 내용을 DTO에 저장
				AnnouncementDTO dto = new AnnouncementDTO();

				dto.setNum(rs.getString("num")); // 일련번호
				dto.setTitle(rs.getString("title")); // 제목
				dto.setContent(rs.getString("content")); // 내용
				dto.setPostdate(rs.getDate("postdate")); // 작성일
				dto.setId(rs.getString("id")); // 작성자 아이디
				dto.setVisitcount(rs.getString("visitcount")); // 조회수

				amt.add(dto); // 결과 목록에 저장
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return amt;
	}

	// 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
	public List<AnnouncementDTO> selectListPage(Map<String, String> map) {
		List<AnnouncementDTO> amt = new Vector<AnnouncementDTO>(); // 결과(게시물 목록)를 담을 변수

		// 쿼리문 템플릿
		String query = " SELECT * FROM announcement ";

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
				AnnouncementDTO dto = new AnnouncementDTO();
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));

				// 반환할 결과 목록에 게시물 추가
				amt.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}

		// 목록 반환
		return amt;
	}

	// 게시글 데이터를 받아 DB에 추가합니다.
	public int insertWrite(AnnouncementDTO dto) {
		int result = 0;

		try {
			// INSERT 쿼리문 작성
			String query = "INSERT INTO announcement (title,content,id) VALUES ( ?, ?, ?)";

			psmt = con.prepareStatement(query); // 동적 쿼리
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getId());

			result = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}

		return result;
	}

//	public AnnouncementDTO selectView(String num) {
//		AnnouncementDTO dto = new AnnouncementDTO();
//
//		// 쿼리문 준비
//		String query = "SELECT a.*, M.name " + " FROM member M INNER JOIN announcement a " + " ON M.id=a.id "
//				+ " WHERE num=?";
//	    String query = "";
//	    query += "SELECT A.*, M.name,                                   ";
//	    query += "       LAG(A.num) OVER(ORDER BY A.num) AS prev_num,   ";
//	    query += "       LEAD(A.num) OVER(ORDER BY A.num) AS next_num,  ";
//	    query += "       LAG(A.title) OVER(ORDER BY A.num) AS prev_title,";
//	    query += "       LEAD(A.title) OVER(ORDER BY A.num) AS next_title ";
//	    query += "  FROM member M INNER JOIN announcement A            ";
//	    query += "    ON M.id = A.id                                   ";
//	    query += " WHERE A.num = ?                                     ";

//	    try {
//	        psmt = con.prepareStatement(query);
//	        psmt.setString(1, num);
//	        rs = psmt.executeQuery();
//
//	        if (rs.next()) {
//	            // 현재 게시글 정보
//	            dto.setNum(rs.getString("num"));
//	            dto.setTitle(rs.getString("title"));
//	            dto.setContent(rs.getString("content"));
//	            dto.setPostdate(rs.getDate("postdate"));
//	            dto.setId(rs.getString("id"));
//	            dto.setVisitcount(rs.getString("visitcount"));
//	            dto.setName(rs.getString("name"));
//
//	        }
//	    } catch (Exception e) {
//	        System.out.println("게시물 상세보기 중 예외 발생");
//	        e.printStackTrace();
//	    }
//
//	    return dto;
//	}

	
	public AnnouncementDTO pnPage(String num) {
		AnnouncementDTO dto = new AnnouncementDTO();
		
		String query = "";
		query += "SELECT A.*                                                  ";
		query += "  FROM (                                                    ";
		query += "		SELECT                                                ";
		query += "			NUM,                                              ";
		query += "			ID,                                               ";
		query += "			TITLE,                                            ";
		query += "			POSTDATE,                                         ";
		query += "			CONTENT,                                          ";
		query += "			LAG(NUM) OVER(ORDER BY NUM) AS PREV_NUM,          ";
		query += "			LEAD(NUM) OVER(ORDER BY NUM) AS NEXT_NUM,         ";
		query += "			LAG(TITLE) OVER(ORDER BY NUM) AS PREV_TITLE,      ";
		query += "			LEAD(TITLE) OVER(ORDER BY NUM) AS NEXT_TITLE      ";
		query += "		FROM ANNOUNCEMENT                                     ";
		query += "	) A                                                       ";
		query += " WHERE NUM = ?                                              ";
		
		try {
			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				// 현재 게시글 정보
				dto.setId(rs.getString("id"));
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				
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
	public void updateVisitCount(String num) {
		// 쿼리문 준비
		String query = "UPDATE announcement SET " + " visitcount=visitcount+1 " + " WHERE num=?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num); // 인파라미터를 일련번호로 설정
			psmt.executeUpdate(); // 쿼리 실행
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}

	// 지정한 게시물을 수정합니다.
	public int updateEdit(AnnouncementDTO dto) {
		int result = 0;

		try {
			// 쿼리문 템플릿
			String query = "UPDATE announcement SET " + " title=?, content=? " + " WHERE num=?";

			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getNum());

			// 쿼리문 실행
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}

		return result; // 결과 반환
	}

	// 지정한 게시물을 삭제합니다.
	public int deletePost(AnnouncementDTO dto) {
		int result = 0;

		try {
			// 쿼리문 템플릿
			String query = "DELETE FROM announcement WHERE num=?";

			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getNum());

			// 쿼리문 실행
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}

		return result; // 결과 반환
	}

}
