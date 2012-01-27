package test;

import logic.User;
import dbconnect.orm.AddUser;

public class Test {
	
	public static void main (String[] args) {
		{	char [] password = {'s','e','u','t'}; 
			User u = new User();
			u.setUserName("Stoutmeisje69");
			u.setPassword(password);
			u.setEmail("xxxkonijntje@hotmail.com");
			AddUser.addUserToDB(u);
		}
		{
			
		}
		
	}
}
