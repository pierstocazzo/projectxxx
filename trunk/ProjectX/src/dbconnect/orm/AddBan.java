package dbconnect.orm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import logic.User;
import chatbox.Ban;
import chatbox.Channel;
import dbconnect.DBAccess;

public class AddBan {
	public static void AddBanToDB (Ban b, User u) {
		DBAccess db = new DBAccess("jdbc:mysql://78.23.248.36:3306/projectx","maxime","chatboxsql");
		Channel c = b.getChannel();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String endDateFormat;
		String banDateFormat;
		
		
		endDateFormat = df.format(b.getEndDate());
		banDateFormat = df.format(b.getBanDate());
		String queryText	=	"INSERT INTO PROJECTX.BANS(CHANNELNAME,ENDDATE,BANDATE,USERNAME,MODERATOR,REASON) "
				+ "VALUES('" + c.getChannelName() + "','" + endDateFormat + "','" + banDateFormat + "','" + u.getUserName() + "','" 
				+ b.getSender().getUserID() + "','" + b.getReason() + "')"; 
		
		db.execute(queryText);
		db.closeConnection();
		
}
}
