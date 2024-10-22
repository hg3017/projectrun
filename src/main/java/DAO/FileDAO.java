package DAO;

import Common.JDBConnect;
import DTO.FileDTO;

public class FileDAO extends JDBConnect {
	
	public FileDAO() {
	}
	
    // 파일 업로드 정보를 데이터베이스에 저장하는 메소드
    public int insertFile(FileDTO dto) {
    	int rs = 0;
    	
        try {
        	String query = "INSERT INTO file (member_id, title, content, ofile, sfile)";
        	
        	query += "VALUES (?, ?, ?, ?, ?)";
        	
            psmt = con.prepareStatement(query);

            psmt.setString(1, dto.getMember_id());
            psmt.setString(2, dto.getTitle());
            psmt.setString(3, dto.getContent());
            psmt.setString(4, dto.getOfile());
            psmt.setString(5, dto.getSfile());

            rs = psmt.executeUpdate();
            
        } catch (Exception e) {
        	System.out.println("파일업로드 중 예외 발생");
            e.printStackTrace();
        }
        return rs;
    }

}
