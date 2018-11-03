package project.db;
import java.sql.*;

import project.db.DbAccessConfiguartion;
public class DbAccessImpl extends DbAccessConfiguartion {
	static Connection conn;
	public static Connection connect() {
		//this class is done
		//connect db classs
		try {
	        
	         Class.forName("com.mysql.jdbc.Driver").newInstance();
	         conn = DriverManager.getConnection(DbAccessConfiguartion.DB_CONNECTION_URL, DbAccessConfiguartion.DB_CONNECTION_USERNAME, DbAccessConfiguartion.DB_CONNECTION_PASSWORD);
	         
	     } catch (Exception ex) {
	         ex.printStackTrace();
	     }
		
			return conn;
	}
	
	//statement to return a result set
	public static ResultSet retrieve(String query) {
		ResultSet rs = null;
		try {
		Statement statement = conn.createStatement();
		
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	//statement to execute create working
	public static int create(String query) {
		Statement statement = null;
		try {
			statement = conn.createStatement();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		int i = 0;
		try {
			i = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return i;
		
	}
	//statement to execute update working
	public static int update(String query) {
		Statement statement = null;
		int i = 0;
		try {
			statement = conn.createStatement();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			i = statement.executeLargeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return i;
		
	}
	//statement to execute delete working
	public static int delete(String query) {
		Statement statement = null;
		
		int i = 0;
		try {
			statement = conn.createStatement();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			i = statement.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return i;
		
	}
	//statement to execute disconnect working
	public static void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
