package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Common.JDBConnect;
import DTO.CrewBoardDTO;


public class CrewBoardDAO extends JDBConnect{
	public CrewBoardDAO () {
		
	}
	
	public int selectCount(Map<String, String> map) {
		int totalCount = 0;
		
		String query = "select count(*) from crewboard";
		if(map.get("searchWord") != null) {
			query += "where" +  map.get("searchField") + " "
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
	
	public List<CrewBoardDTO> seleList(Map<String, String> map) {
		List<CrewBoardDTO> cb = new ArrayList<CrewBoardDTO>();
		
		
		return cb;
	}

}
