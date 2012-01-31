package logic;

import java.security.MessageDigest;

import chatbox.Ban;

public class UserHandler {
	
	public User logIn( String username, char[] password ) {
		User u = User.getUser(username);
		if( u != null ) {
			if( !this.equalsPassword(u, password) ) 
				u = null;
		}
		return u;
	}
	
	private boolean equalsPassword( User u, char[] password ) {
		boolean isPassword = false;
		if( password.length > 0 ) {
			char[] pwdUser = u.getPassword();
			char[] inpwd = this.encryptedPassword(password);
			if( pwdUser.equals(inpwd) ) 
				isPassword = true;
		}
		return isPassword;
	}
	
	private char[] encryptedPassword( char[] password ) {
		String encpwd = null;
		String pwd = null;
		for( char c : password ) {
			pwd += c;
		}
		
		try {
	         MessageDigest sha = MessageDigest.getInstance("MD5");
	         byte[] tmp = pwd.getBytes();
	         sha.update(tmp);
	         encpwd = new String(sha.digest());
	      }
	      catch( java.security.NoSuchAlgorithmException e ) {
	         System.out.println( e.toString() );
	      }
		
		char[] encpsw = new char[20];
		for( int i=0; i<encpwd.length(); i++ ) {
			encpsw[i] = encpwd.charAt(i);
		}
		return encpsw; //encpwd;
	}
	
	public User changePassword( String username, char[] password ) {
		User u = User.getUser(username);
		if( (u != null) && (!this.equalsPassword(u, password))  ) {
			u.setPassword(this.encryptedPassword(password));
		}
		return u;
	}
	
	public User register( String username, char[] password, String email  ) {
		User u = null;
		if( username != null && username.length() >= 3 )
			u = new User(username);
		if( password != null && password.length >= 6 )
			u.setPassword(this.encryptedPassword(password));
		u.setEmail(email);
		return u;
	}
	
	public User ban( String username, Ban b ) {
		User u = User.getUser(username);
		if( u != null && b != null ) {
			u.getBans().add(b);
		}
		return u;
	}

}
