package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import DTO.AnnouncementDTO;
import Common.JDBConnect;

public class AnnouncementDAO extends JDBConnect {
	
	public AnnouncementDAO() {
		// TODO Auto-generated constructor stub
	}

	// 검색 조건에 맞는 게시물의 개수를 반환합니다.
    public int selectCount(Map<String, String> map) {
        int totalCount = 0; // 결과(게시물 수)를 담을 변수

        // 게시물 수를 얻어오는 쿼리문 작성
        String query = "SELECT COUNT(*) FROM announcement";
        if (map != null && map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField") + " "
                   + " LIKE '%" + map.get("searchWord") + "%'";
        }
        

        try {
            stmt = con.createStatement();   // 쿼리문 생성
            rs = stmt.executeQuery(query);  // 쿼리 실행
            if(rs.next()) {  // 커서를 첫 번째 행으로 이동
            	totalCount = rs.getInt(1);  // 첫 번째 칼럼 값을 가져옴
            }
           
        }
        catch (Exception e) {
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
        	
        	rs = psmt.executeQuery();  // 쿼리 실행
        	
        	
            while (rs.next()) {  // 결과를 순화하며...
                // 한 행(게시물 하나)의 내용을 DTO에 저장
                AnnouncementDTO dto = new AnnouncementDTO(); 

                dto.setNum(rs.getString("num"));          // 일련번호
                dto.setTitle(rs.getString("title"));      // 제목
                dto.setContent(rs.getString("content"));  // 내용
                dto.setPostdate(rs.getDate("postdate"));  // 작성일
                dto.setId(rs.getString("id"));            // 작성자 아이디
                dto.setVisitcount(rs.getString("visitcount"));  // 조회수

                amt.add(dto);  // 결과 목록에 저장
            }
        } 
        catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        }
		return amt;
    }
    
    // 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
    public List<AnnouncementDTO> selectListPage(Map<String, Object> map) {
        List<AnnouncementDTO> amt = new Vector<AnnouncementDTO>();  // 결과(게시물 목록)를 담을 변수
        
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
        } 
        catch (Exception e) {
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

            psmt = con.prepareStatement(query);  // 동적 쿼리 
            psmt.setString(1, dto.getTitle());  
            psmt.setString(2, dto.getContent());
            psmt.setString(3, dto.getId());  
            
            result = psmt.executeUpdate();
            
        }
        catch (Exception e) {
            System.out.println("게시물 입력 중 예외 발생");
            e.printStackTrace();
        }
       
        return result;    
    }
    public AnnouncementDTO selectView(String num) { 
        AnnouncementDTO dto = new AnnouncementDTO();
        
        // 쿼리문 준비
        String query = "SELECT B.*, M.name " 
                     + " FROM member M INNER JOIN announcement B " 
                     + " ON M.id=B.id "
                     + " WHERE num=?";

        try {
            psmt = con.prepareStatement(query);
            psmt.setString(1, num);    // 인파라미터를 일련번호로 설정 
            rs = psmt.executeQuery();  // 쿼리 실행 

            // 결과 처리
            if (rs.next()) {
                dto.setNum(rs.getString(1)); 
                dto.setTitle(rs.getString(2));
                dto.setContent(rs.getString("content"));
                dto.setPostdate(rs.getDate("postdate"));
                dto.setId(rs.getString("id"));
                dto.setVisitcount(rs.getString(6));
                dto.setName(rs.getString("name")); 
            }
        } 
        catch (Exception e) {
            System.out.println("게시물 상세보기 중 예외 발생");
            e.printStackTrace();
        }
        
        return dto; 
    }
    public void updateVisitCount(String num) { 
        // 쿼리문 준비 
        String query = "UPDATE announcement SET "
                     + " visitcount=visitcount+1 "
                     + " WHERE num=?";
        
        try {
            psmt = con.prepareStatement(query);
            psmt.setString(1, num);  // 인파라미터를 일련번호로 설정 
            psmt.executeUpdate();     // 쿼리 실행 
        } 
        catch (Exception e) {
            System.out.println("게시물 조회수 증가 중 예외 발생");
            e.printStackTrace();
        }
    }
    
    // 지정한 게시물을 수정합니다.
    public int updateEdit(AnnouncementDTO dto) { 
        int result = 0;
        
        try {
            // 쿼리문 템플릿 
            String query = "UPDATE announcement SET "
                         + " title=?, content=? "
                         + " WHERE num=?";
            
            // 쿼리문 완성
            psmt = con.prepareStatement(query);
            psmt.setString(1, dto.getTitle());
            psmt.setString(2, dto.getContent());
            psmt.setString(3, dto.getNum());
            
            // 쿼리문 실행 
            result = psmt.executeUpdate();
        } 
        catch (Exception e) {
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
        } 
        catch (Exception e) {
            System.out.println("게시물 삭제 중 예외 발생");
            e.printStackTrace();
        }
        
        return result; // 결과 반환
    }
}
