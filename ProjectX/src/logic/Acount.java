package logic;

import java.util.Calendar;
import java.util.Date;

public class Acount {
	
	private String name;
	private String surName;
	private Calendar birtDate;
	private String birthPlace;
	private final Date joinDate;
	private char sex;
	private String email;
	
	public Acount() {
		joinDate = Calendar.getInstance().getTime();
	}


	// Getters
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * @return the birtDate
	 */
	public Calendar getBirtDate() {
		return birtDate;
	}
	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}
	/**
	 * @return the join date
	 */
	public Date getJoinDate() {
		return this.joinDate;
	}
	/**
	 * @return the sex
	 */
	public char getSex() {
		return this.sex;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	// Setters
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	/**
	 * @param birtDate the birtDate to set
	 */
	public void setBirtDate(Calendar birtDate) {
		this.birtDate = birtDate;
	}
	/**
	 * @param birthPlace the birthPlace to set
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	/**
	 * @param sex
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String emailAddress) {
		this.email = emailAddress;
	}
	
}
