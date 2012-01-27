package dbconnect.orm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import dbconnect.DBAccess;
import logic.Account;

public class AddAccount {

	public static void addAccountToDB (Account a) {
		
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx","maxime","chatboxsql");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String birthDateFormat;
		String joinDateFormat;
		
		try {		
		birthDateFormat = df.format(a.getBirthDate());
		joinDateFormat = df.format(a.getJoinDate());
		
		String queryText	= "INSERT INTO PROJECTX.ACCOUNTS(FIRSTNAME,LASTNAME,BIRTHDATE,BIRTHPLACE,JOINDATE,SEX) "
				+ "VALUES('" + a.getFirstName() + "','" + a.getLastName() + "','" + birthDateFormat + "','" 
				+ a.getBirthPlace() + "','" + joinDateFormat + "','" + a.getSex() + "')";
		
		db.execute(queryText);
		}
		
		catch (Exception e) {
			  System.err.println( e);
		}
		
		finally {
			db.closeConnection();
		}
	}
}
