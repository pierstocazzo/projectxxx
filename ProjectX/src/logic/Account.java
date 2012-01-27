package logic;


import java.util.Calendar;
import java.util.Date;

public class Account {
	
	private String firstName;
	private String lastName;
	private Calendar birthDate;
	private String birthPlace;
	private final Date joinDate;
	private char sex;
	
	
	public Account() {
		joinDate = Calendar.getInstance().getTime();
		
	}


	// Getters
	/**
	 * @return the name
	 */
	public String getName() {
		return firstName;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return lastName;
	}
	/**
	 * @return the birtDate
	 */
	public Calendar getBirthDate() {
		return birthDate;
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


	// Setters
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.firstName = name;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.lastName = surName;
	}
	/**
	 * @param birtDate the birtDate to set
	 */
	public void setBirtDate(Calendar birtDate) {
		this.birthDate = birtDate;
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
	
}
