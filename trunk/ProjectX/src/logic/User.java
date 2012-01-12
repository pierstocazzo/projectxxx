package logic;

import java.util.*;

import chatbox.Ban;



public class User {
	
	public enum Role {
		OWNER, MODERATOR, CLIENT;
	}
	
	private final int userID;
	private Role r;
	private Acount acountInfo;
	private String userName;
	private char[] password;
	private static List<User> users = new ArrayList<User>();
	private List<Ban> bans;
	
	protected User() {
		userID = users.size() + 1;
		this.setRole( Role.CLIENT );
		password = new char[20];
		bans = new ArrayList<Ban>();
		users.add(this);
	}
	public User( String userName ) {
		this();
		this.setUserName(userName);
	}

	// Getters
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @return the r
	 */
	public Role getRole() {
		return r;
	}
	/**
	 * @return the data
	 */
	public Acount getAcountInfo() {
		return acountInfo;
	}
	/**
	 * @return the username
	 */
	public String getUserName() {
		return this.userName;
	}
	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return this.password;
	}
	/**
	 * @return the bans
	 */
	public List<Ban> getBans() {
		return bans;
	}
	/**
	 * @return the users
	 */
	public static List<User> getUsers() {
		return User.users;
	}
	/**
	 * Returns a User with the given user name
	 * @param username
	 * @return
	 */
	public static User getUser(String username) {
		User user = null;
		for( User u : users ) {
			if( username.equalsIgnoreCase(u.getUserName()) ) {
				user = u;
				break;
			}
		}
		return user;
	}

	// Setters
	/**
	 * @param role the r to set
	 */
	public void setRole(Role role) {
		this.r = role;
	}
	/**
	 * @param data the data to set
	 */
	public void setAcountInfo(Acount acountInfo) {
		this.acountInfo = acountInfo;
	}
	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		if( userName != null )
			this.userName = userName;
	}
	/**
	 * @param password
	 */
	public void setPassword(char[] password) {
		this.password = password;
	}
	/**
	 * @param bans the bans to set
	 */
	public void setBans(List<Ban> bans) {
		this.bans = bans;
	}
	/**
	 * @param users
	 */
	public static void setUsers(List<User> users) {
		User.users = users;
	}
	
	
	/**
	 * Deletes a given user from the collection
	 * @param u
	 */
	public static void deleteUser( User u ) {
		if( users.contains(u) )
			users.remove(u);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userName.hashCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		User u = (User) o;
		if (!userName.equals(u.userName))
			return false;
		return true;
	}
	
}
