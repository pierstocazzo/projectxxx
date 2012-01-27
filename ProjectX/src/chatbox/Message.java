/**
 * 
 */
package chatbox;

import java.sql.Timestamp;

import logic.User;

/**
 * @author Sepp Hoedenaeken
 *
 */
public class Message {
	
	private User sender;
	private String comment;
	private User receiver = null;
	private Timestamp timeStamp;
	
	public Message() {
		
	}
	public Message( User sender, String comment ) {
		this();
		this.setSender(sender);
		this.setComment(comment);
	}
	
	
	/**
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @return the receiver
	 */
	public User getReceiver() {
		return receiver;
	}
	/**
	 * @return the timeStamp
	 */
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	
	
	/**
	 * @param sender the sender to set
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
}
