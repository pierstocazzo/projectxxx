package chatbox;

import logic.User;
import logic.UserHandler;

import java.util.*;

public class ChannelHandler {
	
	private List<Channel> channels;
	
	public ChannelHandler() {
		channels = new ArrayList<Channel>();
	}
	
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	public Channel getChannel( String channelName ) {
		Channel channel = null;
		for( Channel c : channels ) {
			if( channelName.equalsIgnoreCase(c.getChannelName()) ) {
				channel = c;
				break;
			}
		}
		return channel;
	}

	public Channel makeChannel( String channelName, String userName ) {
		Channel c = new Channel(channelName, User.getUser(userName));
		return c;
	}
	
	public Message userJoinedChannel( String userName, String channelName ) {
		User u = User.getUser(userName);
		Channel c = getChannel(channelName);
		Message m = null;
		
		if( u != null && c != null ) {
			c.addMember(u);
			m = new Message(u, "joined channel");
		}
		return m;
	}
	
	public Message userLeftChannel( String userName, String channelName ) {
		User u = User.getUser(userName);
		Channel c = getChannel(channelName);
		Message m = null;
		
		if( u != null && c != null ) {
			c.removeMember(u);
			m = new Message(u, "left channel");
		}
		
		return m;
	}
	
	public Message userBanned( String userName, String channelName, UserHandler handler ) {
		Ban b = null;
		User u = User.getUser(userName);
		Channel c = getChannel(channelName);
		
		if( u != null && c != null ) {
			c.removeMember(u);
			//b = new Ban(mod, ch, reason, d, duration);
		}
		
		return b;
	}
	
	

}
