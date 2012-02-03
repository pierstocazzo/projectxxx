package dbconnect.read.initial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chatbox.Ban;
import chatbox.Channel;

import logic.Account;
import logic.User;
import dbconnect.DBAccess;
	

public class GetAllUsers  {
	
	
	private static List<Channel> channels;
	
	public static List<User> getAllUsersFromDB () {
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx","maxime","chatboxsql");
		String queryText = ("SELECT * FROM USERS INNER JOIN ACCOUNTS" + 
							" ON USERS.USERID=ACCOUNTS.USERID");
		List<User> users = new ArrayList<User>();
		
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
				u.setBans(getAllBansFromDB(u,channels));
				users.add(u);
				
								
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try  {
				db.closeConnection();
			}
			catch (Exception e) {}
		}
		
		
		return users;
		
	}
	
	public static List<Ban> getAllBansFromDB(User u, List<Channel> c) {
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx","maxime","chatboxsql");
		
		String queryText = ("SELECT * FROM BANS INNER JOIN USERS" +
							" ON BANS.MODERATOR=USERS.USERID WHERE BANS.USERID='" + u.getUserID() + "'");
		List<Ban> bans = new ArrayList<Ban>();

		ResultSet rs = db.executeQuery(queryText);
		try {
			while (rs.next()) {
				User u1 = new User(rs.getString("USERNAME"),rs.getInt("USERS.USERID"));
				u1.setPassword(rs.getString("PASSWORD").toCharArray());
				u1.setEmail(rs.getString("EMAIL"));
				Channel channel = null;
				for (Channel ch : c){
					if (ch.getChannelName()==rs.getString("CHANNELNAME")){
						channel = ch;
						break;
					}
				}
				
				Ban b = new Ban(u1, channel ,rs.getString("REASON"),rs.getDate("BANDATE")
						,rs.getDate("ENDDATE"));
				bans.add(b);
			}
		}
		catch(SQLException sql){
			
		}
		return bans;
		
	}
	
	public static List<Channel> getAllChannelsFromDB() {
		return channels;
		
	}
	
}