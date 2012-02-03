package chatbox;

import java.util.Date;
import logic.User;

public class Ban extends Message {
	
	private Channel channel;
	private int duration;
	private final Date banDate;
	private Date endDate;
	
	public Ban( User mod, Channel ch, String reason, Date d,  int duration) {
		super(mod, reason);
		this.banDate = d;
		this.duration = duration;
	}
	public Ban( User mod, Channel ch, String reason, Date d, Date endDate) {
		super(mod, reason);
		this.banDate = d;
		this.endDate = endDate;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return this.getComment();
	}
	/**
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @return the ban date
	 */
	public Date getBanDate() {
		return this.banDate;
	}

	
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.setComment(reason);
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Date getEndDate() {
		return new Date();
	}
	
	public void setEndDate (Date d ) {
		
	}
}
