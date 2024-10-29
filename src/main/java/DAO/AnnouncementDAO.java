package DAO;

import java.io.File;
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

	public List<AnnouncementDTO> selectList(Map<String, String> map) {
		List<AnnouncementDTO> amt = new ArrayList<AnnouncementDTO>();

		String query = "SELECT * FROM announcement";
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

			while (rs.next()) { // 결과를 순화하며...
				// 한 행(게시물 하나)의 내용을 DTO에 저장
				AnnouncementDTO dto = new AnnouncementDTO();

				dto.setIdx(rs.getString("idx")); // 일련번호
				dto.setTitle(rs.getString("title")); // 제목
				dto.setContent(rs.getString("content")); // 내용
				dto.setRegidate(rs.getDate("regidate")); // 작성일
				dto.setMember_id(rs.getString("member_id")); // 작성자 아이디
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

		query += " ORDER BY idx DESC ";
		query += " LIMIT ? OFFSET ?";

		try {
			// 쿼리문 완성
			psmt = con.prepareStatement(query);

			// 쿼리문 실행
			rs = psmt.executeQuery();

			while (rs.next()) {
				// 한 행(게시물 하나)의 데이터를 DTO에 저장
				AnnouncementDTO dto = new AnnouncementDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegidate(rs.getDate("regidate"));
				dto.setMember_id(rs.getString("member_id"));
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
			String query = "INSERT INTO announcement (title,content,member_id,ofile,sfile) VALUES ( ?, ?, ?, ?, ?)";

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
	
	public AnnouncementDTO pnPage(String idx) {
		AnnouncementDTO dto = new AnnouncementDTO();
		
		String query = "";
		query += "SELECT A.*                                                  ";
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
		query += "		FROM ANNOUNCEMENT                                     ";
		query += "	) A                                                       ";
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
		String query = "UPDATE announcement SET visitcount=visitcount+1 WHERE idx=?";

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
	public int updateEdit(AnnouncementDTO dto) {
		int result = 0;

		try {
			String selectQuery = "SELECT sfile FROM announcement WHERE idx=?";
	        psmt = con.prepareStatement(selectQuery);
	        psmt.setString(1, dto.getIdx());
	        rs = psmt.executeQuery();

	        String oldFilePath = null;
	        if (rs.next()) {
	            oldFilePath = System.getProperty("user.home") + "/Desktop/kdigital/jsp/jspws2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/running/JSP/Upload/" + rs.getString("sfile"); // 실제 파일 경로에 맞게
	        }

	        // 2. 새로운 파일이 업로드되었는지 확인 후 기존 파일 삭제
	        if (dto.getSfile() != null && !dto.getSfile().isEmpty() && oldFilePath != null) {
	            File oldFile = new File(oldFilePath);
	            if (oldFile.exists()) {
	            	boolean deleted = oldFile.delete();
	                System.out.println("파일 삭제 여부: " + deleted);
	                if (!deleted) {
	                    System.out.println("파일 삭제 실패 - 경로: " + oldFilePath);
	                }
	            } else {
	                System.out.println("삭제할 파일이 존재하지 않습니다 - 경로: " + oldFilePath);
	            }
	        }
			// 쿼리문 템플릿
			String query = "UPDATE announcement SET title=?, content=?, ofile=?, sfile=? WHERE idx=?";

			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			psmt.setString(5, dto.getIdx());

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
			String query = "DELETE FROM announcement WHERE idx=?";

			// 쿼리문 완성
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getIdx());

			// 쿼리문 실행
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		} 

		return result; // 결과 반환
	}

}
