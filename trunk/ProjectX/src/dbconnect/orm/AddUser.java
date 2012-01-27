package dbconnect.orm;

import logic.User;
import dbconnect.DBAccess;

public class AddUser {
	private String convertPassword (User u) {
		String password = "";
		for (int i = 0; i < u.getPassword().length; i++) {
			password += u.getPassword()[i];			
		}
		return password;
	}
	
	public void addUserToDB(User u) {
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx.users","Maxime","chatboxsql");
		
		String queryText 	= "INSERT INTO PROJECTX.USERS (USERNAME, PASSWORD, EMAIL) "
							+ "VALUES('" + u.getUserName() +"','" + convertPassword(u) + "','" + u.getEmail() + "')";
		
		db.execute(queryText);
		db.closeConnection();
	}
}
