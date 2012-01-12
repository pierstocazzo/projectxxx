/**
 * 
 */
package chatbox;

import logic.User;
import java.util.*;

/**
 * @author Sepp Hoedenaeken
 *
 */
public class Channel {
	
	private String channelName;
	private String description;
	private boolean privateChannel;
	private Map<String, User> members;
	private char[] password;
	
	protected Channel() {
		members = new HashMap<String, User>();
		password = new char[20];
		this.setPrivateChannel(false);
	}
	public Channel( String name, User owner ) {
		this();
		this.setChannelName(name);
		this.addMember(owner);
		owner.setRole(User.Role.OWNER);
	}
	
	
	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the privateChannel
	 */
	public boolean isPrivateChannel() {
		return privateChannel;
	}
	/**
	 * @return the members
	 */
	public Map<String, User> getMembers() {
		return members;
	}
	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}
	
	
	/**
	 * @param channelName the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param privateChannel the privateChannel to set
	 */
	public void setPrivateChannel(boolean privateChannel) {
		this.privateChannel = privateChannel;
	}
	/**
	 * @param members the members to set
	 */
	public void setMembers(Map<String, User> members) {
		this.members = members;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	public void addMember( User u ) {
		if( !this.getMembers().containsKey(u.getUserName()) )
			this.getMembers().put(u.getUserName(), u);
	}
	
	
}
