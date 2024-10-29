package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Common.DBConnectionPool;
import Common.JDBConnect;
import DTO.AnnouncementDTO;
import DTO.CrewDTO;

public class CrewDAO {
	
	
	private DBConnectionPool dbConnectionPool;

    // DBConnectionPool 인스턴스를 생성자로 전달
    public CrewDAO(DBConnectionPool dbConnectionPool) {
        this.dbConnectionPool = dbConnectionPool;
    }
	
	public List<CrewDTO> selectCrewList() {
		List<CrewDTO> crewList = new ArrayList<CrewDTO>();
		CrewDTO crew = null;
		Connection con = null;
		
		
		String sql = "select "
				+ "	c.idx as idx,"
				+ "    c.name as name,"
				+ "    lo.name as location_id,"
				+ "    c.regidate as regidate "
				+ "from "
				+ "	crew c"
				+ "    inner join location lo on c.location_id = lo.id";
		try {
			con = dbConnectionPool.getConnection();
			var psmt = con.prepareStatement(sql);
			var rs = psmt.executeQuery();
			
			while (rs.next()) { 
                
				crew = new CrewDTO(); 

				crew.setIdx(rs.getInt("idx"));          
				crew.setName(rs.getString("name"));      
				crew.setLocation_id(rs.getString("location_id")); 
				crew.setRegidate(rs.getDate("regidate"));
				
                crewList.add(crew); 
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//close();
		}
		return crewList;			
	}
	
	
		
	
	public CrewDTO selectCrew(String name) {
		CrewDTO crew = null;
		Connection con = null;
		
		String sql = "select idx, name, location_id, description, regidate from crew where name = ?";
		
		try {
			con = dbConnectionPool.getConnection();
			var psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			var rs = psmt.executeQuery();
			while (rs.next()) { 
				crew = new CrewDTO(); 

				crew.setIdx(rs.getInt("Idx"));          
				crew.setName(rs.getString("name"));      
				crew.setLocation_id(rs.getString("location_id")); 
				crew.setDescripton(rs.getString("description"));
				crew.setRegidate(rs.getDate("regidate"));   
				
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
		return crew;
	}
	
	public int registCrew(CrewDTO dto) {
		
		Connection con = null;
		int rs = 0;
		
		String sql = "insert into crew (name, location_id, description, regidate) "
				+ " values(?, ?, ?, ?) ";
		
		try {
			con = dbConnectionPool.getConnection();
			// JDBConnect 에서 상속받은 psmt 객체를 통해 jdbc 에 쿼리를 요청합니다. 
			// 미리 정의한 문자열 sql 의 ? 의 자리에 id 값을 입력하고 쿼리를 작동합니다. 
			var psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getLocation_id());
			psmt.setString(3, dto.getDescripton());
			psmt.setDate(4, java.sql.Date.valueOf(LocalDate.now()));

			// 결과값이 있는 경우 1을 리턴하여 rs 의 값을1로 변경합니다. 
			rs = psmt.executeUpdate();		
			
		} catch (SQLException e) {
			// 예외 발생시 에러메시지를 출력합니다. 
			e.printStackTrace();
		} finally {
			// 작업이 종료된 후 dbconn 을 종료합니다.
			// close();
		}
		
		return rs;
	}
	
	public int registCrewMaster(String crew_name, String member_id) {
		int result = 0;
		Connection con = null;
		
		
		String sql = "insert into crew_member (crew_name, member_id, status) values (?, ?, 'Master');";
		try {
			con = dbConnectionPool.getConnection();
			var psmt = con.prepareStatement(sql);
			
			psmt.setString(1, crew_name);
			psmt.setString(2, member_id);
			
			result = psmt.executeUpdate();	
            
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
		return result;	
	}
	
	
		

}
