package dbconnect.read.initial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import chatbox.Ban;

import logic.Account;
import logic.User;
import dbconnect.DBAccess;
	
@SuppressWarnings("unused")
public class GetAllUsers extends DBAccess {
	private static List<User> users;
	
	public GetAllUsers(String url, String user, String password) {
		super(url, user, password);
	}

	public static List<User> getAllUsersFromDB () {
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx","maxime","chatboxsql");
		String queryText = ("SELECT * FROM PROJECTX.USERS, PROJECTX.ACCOUNTS" + 
							"WHERE USERS.USERID=ACCOUNTS.USERID");
		
		
		ResultSet rs = db.executeQuery(queryText);
		
		try {
			while (rs.next()) {
				User u = new User(rs.getString("USERNAME"),rs.getInt("USERID"));
				u.setPassword(rs.getString("PASSWORD").toCharArray());
				u.setEmail(rs.getString("EMAIL"));
				Account a = new Account(rs.getDate("JOINDATE"));
				a.setFirstName(rs.getString("FIRSTNAME"));
				a.setLastName(rs.getString("LASTNAME"));
				a.setBirthPlace(rs.getString("BIRTHPLACE"));
				a.setBirthDate(rs.getDate("BIRTHDATE"));
				a.setSex(rs.getString("SEX").toCharArray()[0]);
				u.setAcountInfo(a);
				//Ban b = new Ban(u, null, queryText, null, 0);
				users.add(u);
				
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return users;
		
	}
	
}