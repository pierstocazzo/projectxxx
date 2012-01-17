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
	private Set<User> moderators;
	private Set<User> members;
	private char[] password;
	private User owner;

	protected Channel() {
		moderators = new TreeSet<User>();
		members = new TreeSet<User>();
		password = new char[20];
		this.setPrivateChannel(false);
	}

	public Channel(String name, User owner) {
		this();
		this.setChannelName(name);
		this.addMember(owner);
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
	 * @return the moderators
	 */
	public Set<User> getModerators() {
		return moderators;
	}

	/**
	 * @return the members
	 */
	public Set<User> getMembers() {
		return members;
	}

	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param channelName
	 *            the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param privateChannel
	 *            the privateChannel to set
	 */
	public void setPrivateChannel(boolean privateChannel) {
		this.privateChannel = privateChannel;
	}

	/**
	 * @param moderators
	 *            the moderators to set
	 */
	public void setModerators(Set<User> moderators) {
		this.moderators = moderators;
	}

	/**
	 * @param members
	 *            the members to set
	 */
	public void setMembers(Set<User> members) {
		this.members = members;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(char[] password) {
		this.password = password;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void addMember(User u) {
		this.getMembers().add(u);
	}

	public User removeMember(User u) {
		this.getMembers().remove(u);
		return u;
	}

	public void addModerator(User u) {
		this.getModerators().add(u);
	}

	public User removeModerator(User u) {
		this.getModerators().remove(u);
		return u;
	}

}
