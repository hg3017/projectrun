package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Common.JDBConnect;
import DTO.CrewDTO;
import DTO.CrewMemberDTO;

public class CrewMemberDAO extends JDBConnect {
	
	public List<CrewMemberDTO> selectCrewMemberList(String crew_name) {
		List<CrewMemberDTO> crewMemberList = new ArrayList<CrewMemberDTO>();
		CrewMemberDTO crewMember = null;
		
		String sql = 
				"select cm.idx, cm.crew_name, cm.member_id, cm.status, mem.member_image_idx "
				+ "from crew_member as cm inner join member as mem on cm.member_id = mem.id "
				+ "where cm.crew_name = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, crew_name);
			rs = psmt.executeQuery();
			
			while (rs.next()) { 
                
				crewMember = new CrewMemberDTO(); 
				
				crewMember.setIdx(rs.getInt("idx"));          
				crewMember.setCrew_name(rs.getString("crew_name"));      
				crewMember.setMember_id(rs.getString("member_id")); 
				crewMember.setStatus(rs.getString("status"));
				crewMember.setMember_image(rs.getInt("member_image_idx"));
				
							
				crewMemberList.add(crewMember); 
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
		
		return crewMemberList;			
	}
	
	public List<CrewMemberDTO> selectCrewMainMemberList(String crew_name) {
		List<CrewMemberDTO> crewMemberList = new ArrayList<CrewMemberDTO>();
		CrewMemberDTO crewMember = null;
		
		String sql = " select"
				+ "	cm.idx,"
				+ "    cm.crew_name,"
				+ "    cm.member_id,"
				+ "    cm.status,"
				+ "    mem.member_image_idx,"
				+ "    mem.description"
				+ " from crew_member as cm inner join member as mem on cm.member_id = mem.id "
				+ "where "
				+ "	cm.status not in ('Refuse', 'Waiting')"
				+ " and cm.crew_name = ?"
				+ " order by case when status = 'Master' then 1 else 2 end "
				+ " limit 0, 3";
		
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, crew_name);
			rs = psmt.executeQuery();
			
			while (rs.next()) { 
                
				crewMember = new CrewMemberDTO(); 
				
				crewMember.setIdx(rs.getInt("idx"));          
				crewMember.setCrew_name(rs.getString("crew_name"));      
				crewMember.setMember_id(rs.getString("member_id")); 
				crewMember.setStatus(rs.getString("status"));
				crewMember.setMember_image(rs.getInt("member_image_idx"));
				crewMember.setDescription(rs.getString("description"));
							
				crewMemberList.add(crewMember); 
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
		
		return crewMemberList;
	}
	
	
	
	public String selectCrewMemberStatus(String crew_name, String member_id) {
		
		String sql = "select status from crew_member where crew_name = ? and member_id = ?";
		String result = "";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, crew_name);
			psmt.setString(2, member_id);
			rs = psmt.executeQuery();
			
			while (rs.next()) { 
				result = rs.getString("status");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
	
		return result;			
	}
		
	
	public int insertCrewMember(String crew_name, String member_id) {
		int rs = 0;
		CrewMemberDTO crewMember = null;
		
		String sql = "insert into crew_member (crew_name, member_id, status) values (?, ?, 'Waiting');";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, crew_name);
			psmt.setString(2, member_id);
			
			rs = psmt.executeUpdate();	
            
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
		return rs;			
	}
	
	public int deleteCrewMember(String crew_name, String member_id) {
		int rs = 0;
		CrewMemberDTO crewMember = null;
		
		String sql = "delete from crew_member where member_id = ? and crew_name = ?";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, crew_name);
			psmt.setString(2, member_id);
			
			rs = psmt.executeUpdate();	
            
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
		return rs;			
	}
	
	public int acceptCrewMember(String crew_name, String member_id) {
		int rs = 0;
		CrewMemberDTO crewMember = null;
		
		String sql = "update crew_member set status = 'User' where crew_name = ? and member_id = ?";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, crew_name);
			psmt.setString(2, member_id);
			
			rs = psmt.executeUpdate();	
            
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
		System.out.println(rs);
		return rs;			
	}
	
	public int refuseCrewMember(String crew_name, String member_id) {
		int rs = 0;
		CrewMemberDTO crewMember = null;
		
		String sql = "update crew_member set status = 'Refuse' where crew_name = ? and member_id = ?";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, crew_name);
			psmt.setString(2, member_id);
			
			rs = psmt.executeUpdate();	
            
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
		return rs;			
	}
	
	
	
		

}
