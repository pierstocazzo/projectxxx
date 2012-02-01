package dbconnect.orm;
		
import logic.User;
import chatbox.Channel;
import dbconnect.DBAccess;
		
public class AddModerator {
	public static void AddModeratorToDB (Channel c, User u) {
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx","maxime","chatboxsql");
			
	
		String queryText	=	"INSERT INTO PROJECTX.USERS(USERNAME,CHANNELNAME) "
		 		+ "VALUES('" + u.getUserName() + "','" + c.getChannelName() + "')"; 
			
		db.execute(queryText);
		db.closeConnection();
			
	}

}