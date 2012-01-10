package logic;

import java.util.*;

enum Role {
	OWNER, MODERATOR, CLIENT;
}

public class User {
	
	private final int userID;
	private Role r;
	private Acount acountInfo;
	private String userName;
	private char[] password;
	private static List<User> users = new ArrayList<User>();
	
	public User() {
		userID = users.size() + 1;
		this.setRole( Role.CLIENT );
		password = new char[20];
		users.add(this);
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
			if( username.equals(u.getUserName()) ) {
				user = u;
				break;
			}
		}
		return user;
	}

	// Setters
	/**
	 * @param r the r to set
	 */
	public void setRole(Role r) {
		this.r = r;
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
		this.userName = userName;
	}
	/**
	 * @param password
	 */
	public void setPassword(char[] password) {
		this.password = password;
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
		if( !users.contains(u) )
			users.remove(u);
	}
	
}
