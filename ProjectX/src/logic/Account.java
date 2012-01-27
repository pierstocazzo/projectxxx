package logic;


import java.util.Calendar;
import java.util.Date;

public class Account {
	
	private String firstName;
	private String lastName;
	private Date birthDate;
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
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the surName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the birtDate
	 */
	public Date getBirthDate() {
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
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param birtDate the birtDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
