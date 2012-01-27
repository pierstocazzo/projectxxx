package dbconnect.orm;

import logic.User;
import dbconnect.DBAccess;

public class AddUser {
	
	/**
	 * The methode converts a array of subsequent password characters to a password of type 'String' for usage in a database. 
	 */
	private static String convertPassword (User u) {
		String password = "";
		for (int i = 0; i < u.getPassword().length; i++) {
			if (u.getPassword()[i] == 0) {
				break;
			}
			password += u.getPassword()[i];
			
		}
		return password;
	} 
	
	public static void addUserToDB(User u) {
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx","maxime","chatboxsql");
		
		String queryText 	= "INSERT INTO PROJECTX.USERS (USERNAME, PASSWORD, EMAIL) "
							+ "VALUES('" + u.getUserName() +"','" + convertPassword(u) + "','" + u.getEmail() + "')";
		
		db.execute(queryText);
		db.closeConnection();
	}
}
