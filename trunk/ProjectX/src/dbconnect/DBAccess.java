package dbconnect;

import java.sql.*;

public class DBAccess {
	protected Connection con;
	protected Statement stat;
	protected ResultSet rs;
	
	public DBAccess(String url, String user, String password) {
		
		try {
			con = DriverManager.getConnection(url, user, password);
			stat = con.createStatement();
		}
		
		catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	public void execute (String queryText) {
		if (stat != null) {
			try {
				stat.executeUpdate(queryText);
			}
			catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
	
	public ResultSet executeQuery(String queryText) {
		try {
			rs = stat.executeQuery(queryText);
		}
		catch (SQLException e) {
			System.err.println(e);
		}
		return rs;
	}
	
	
	public void closeConnection () {
		try {
			con.close();
		}
		catch (Exception e) {
			
		}
	}
	

}
