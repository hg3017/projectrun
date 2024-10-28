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
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private int initialConnections = 10;
    private int maxConnections = 20;

 	public Connection con;
  	public Statement stmt;
  	public PreparedStatement psmt;
  	public ResultSet rs;

    
    
    public DBConnectionPool(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
    	
        this.jdbcURL = "jdbc:mysql://localhost:3306/run";
        this.jdbcUsername = "sub3";
        this.jdbcPassword = "project";
        connectionPool = new ArrayList<>(initialConnections);
        
        for (int i = 0; i < initialConnections; i++) {
            connectionPool.add(createNewConnection());
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
}
