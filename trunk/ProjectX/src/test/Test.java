package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import logic.Account;
import logic.User;
import dbconnect.orm.AddAccount;


@SuppressWarnings("unused")
public class Test {
	
	public static void main (String[] args) {
		/*{	char [] password = {'s','e','u','t'}; 
			User u = new User();
			u.setUserName("Stoutmeisje69");
			u.setPassword(password);
			u.setEmail("xxxkonijntje@hotmail.com");
			AddUser.addUserToDB(u);
		}*/  
		
		{
			Account a = new Account();
			a.setFirstName("Marie-Jeanne");
			a.setLastName("Vankappellen");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				a.setBirthDate(sdf.parse("1964-05-14"));
			}
			
			catch (ParseException e) {
				  System.err.println( "the date you provided is in an invalid date format.");
			}

			a.setBirthPlace("Reet");
			a.setSex('F');
			AddAccount.addAccountToDB(a);
		}
}
}
