package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnectionPool {
	 private ArrayList<Connection> connectionPool;
	 private int initialConnections = 10;
	 private int maxConnections = 20;
	    
     private String jdbcURL = "jdbc:mysql://localhost:3306/run";
     private String jdbcUsername = "sub3";
	 private String jdbcPassword = "project" ;

	 
//	 public DBConnectionPool(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
	 public DBConnectionPool() throws SQLException {
	        
	        connectionPool = new ArrayList<>(initialConnections);

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            for (int i = 0; i < initialConnections; i++) {
	                connectionPool.add(createNewConnection());
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	 }
	 

	 private Connection createNewConnection() throws SQLException {
	        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	    }
	 
	 public synchronized Connection getConnection() throws SQLException {
	        if (connectionPool.isEmpty()) {
	            if (connectionPool.size() < maxConnections) {
	                connectionPool.add(createNewConnection());
	            } else {
	                throw new SQLException("Maximum pool size reached, no available connections!");
	            }
	        }
	        return connectionPool.remove(connectionPool.size() - 1);
	    }

	    public synchronized void releaseConnection(Connection connection) {
	        if (connection != null) {
	            connectionPool.add(connection);
	        }
	    }

//    
}
	


//public DBConnectionPool(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
//	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		
//		 this.jdbcURL = "jdbc:mysql://localhost:3306/run";
//	        this.jdbcUsername = "sub3";
//	        this.jdbcPassword = "project";
//	        connectionPool = new ArrayList<>(initialConnections);
//	        
//	        System.out.println("커넥션풀 연결 성공 DBConnectionPool ");
//	        
//	        for (int i = 0; i < initialConnections; i++) {
//	        	System.out.println("DBConnectionPool Point2");
//	            connectionPool.add(createNewConnection());
//	        }
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}

//private Connection createNewConnection() throws SQLException {
//System.out.println("DBConnectionPool Point3");
//return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//}

//public synchronized Connection getConnection() throws SQLException {
//  if (connectionPool.isEmpty()) {
//      if (connectionPool.size() < maxConnections) {
//          connectionPool.add(createNewConnection());
//      } else {
//          throw new SQLException("Maximum pool size reached, no available connections!");
//      }
//  }
//  return connectionPool.remove(connectionPool.size() - 1);
//}
//
//public synchronized void releaseConnection(Connection connection) {
//  if (connection != null) {
//      connectionPool.add(connection);
//  }
//}