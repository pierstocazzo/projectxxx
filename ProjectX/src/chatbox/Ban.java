package chatbox;

import java.util.Date;

public class Ban {
	
	private String reason;
	private Channel channel;
	private int duration;
	private final Date banDate;
	
	public Ban( Channel ch, String reason, Date d, int duration ) {
		this.banDate = d;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
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
		this.reason = reason;
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
	
	
}
