package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.JDBConnect;
import DTO.AnnouncementDTO;
import DTO.CrewDTO;

public class CrewDAO extends JDBConnect {
	
	public List<CrewDTO> selectCrewList() {
		List<CrewDTO> crewList = new ArrayList<CrewDTO>();
		CrewDTO crew = null;
		
		String sql = "select "
				+ "	c.idx as idx,"
				+ "    c.name as name,"
				+ "    lo.name as location_id,"
				+ "    c.regidate as regidate "
				+ "from "
				+ "	crew c"
				+ "    inner join location lo on c.location_id = lo.id";
		try {
			psmt = con.prepareStatement(sql);
			
			rs = psmt.executeQuery();
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
		
		String sql = "select idx, name, location_id, description, regidate from crew where name = ?";
		
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
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
	
	
		

}
