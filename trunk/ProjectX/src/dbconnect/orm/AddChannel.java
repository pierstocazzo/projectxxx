package dbconnect.orm;

import logic.User;
import chatbox.Channel;
import dbconnect.DBAccess;

public class AddChannel {
	
	private static String convertPassword (Channel c) {
		String password = "";
		for (int i = 0; i < c.getPassword().length; i++) {
			if (c.getPassword()[i] == 0) {
				break;
			}
			password += c.getPassword()[i];
			
		}
		return password;
	} 
	
	
	public static void AddChannelToDB (Channel c) {
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx","maxime","chatboxsql");
		
		
		String queryText	=	"INSERT INTO PROJECTX.CHANNELS(CHANNELNAME,DESCRIPTION,PIRVATECHANNEL,PASSWORD,OWNER) "
				+ "VALUES('" + c.getChannelName() + "','" + c.getDescription() + "','" + c.isPrivateChannel() + "','" 
				+ convertPassword(c) + "','" + c.getOwner().getUserID() + "')"; 
		
		db.execute(queryText);
		db.closeConnection();
		
	}

}
