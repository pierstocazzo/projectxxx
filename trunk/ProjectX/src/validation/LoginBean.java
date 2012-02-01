package validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import beans.SessionData;

import logic.Account;

public class LoginBean {
    /*  The properties */
	String firstname = "";
	String lastname = "";
	String birthdate = "";
	Date bdate;
	String birthplace = "";
	String gender = "";
	
	SessionData userData = null;
	
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public String getLastname()
	{
		return lastname;
	}
	public void setLastname(String lastname)
	{
		this.lastname = lastname.trim();
	}
	public String getBirthdate()
	{
		return birthdate;
	}
	public void setBirthdate(String birthdate)
	{
		this.birthdate = birthdate.trim();
		this.bdate = stringToDate(birthdate);
		
	}
	public SessionData getUserData() {
		return userData;
	}
	public void setUserData(SessionData userData) {
		System.out.println("Session data set");
		this.userData = userData;
	}
	public String getBirthplace()
	{
		return birthplace;
	}
	public void setBirthplace(String birthplace)
	{
		this.birthplace = birthplace.trim();
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender.trim();
	}
	
	private Date stringToDate(String date)
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		try
		{
			Date temp = df.parse(date);
			return temp;
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

    /* Errors */
    public static final Integer ERROR_FNAME_ENTER = new Integer(1);
    public static final Integer ERROR_FNAME_INVALID = new Integer(2);
    public static final Integer ERROR_LNAME_ENTER = new Integer(3);
    public static final Integer ERROR_LNAME_INVALID = new Integer(4);
    public static final Integer ERROR_BDATE_ENTER = new Integer(5);
    public static final Integer ERROR_BDATE_INVALID = new Integer(6);
    public static final Integer ERROR_BPLACE_ENTER = new Integer(7);

    // Holds error messages for the properties
    Map errorCodes = new HashMap();

    // Maps error codes to textual messages.
    // This map must be supplied by the object that instantiated this bean.
    Map msgMap;
    public void setErrorMessages(Map msgMap) {
        this.msgMap = msgMap;
    }

    public String getErrorMessage(String propName) {
        Integer code = (Integer)(errorCodes.get(propName));
        if (code == null) {
            return "";
        } else if (msgMap != null) {
            String msg = (String)msgMap.get(code);
            if (msg != null) {
                return msg;
            }
        }
        return "Error";
    }

    /* Form validation and processing */
    public boolean isValid() {
        // Clear all errors
        errorCodes.clear();

        //Validate name
        if(firstname.length() == 0)
        	{
        		errorCodes.put("firstname", ERROR_FNAME_ENTER);
        		//fName = "";
        	}
        if(lastname.length() == 0)
        {
        	errorCodes.put("lastname", ERROR_LNAME_ENTER);
        }
        
        //Validate birthDate
        if(birthdate.length() == 0)
        {
        	errorCodes.put("birthdate", ERROR_BDATE_ENTER);
        	birthdate = "";
        }
        else if(!birthdate.matches("(0[1-9]|[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012]|[1-9])-(19|20)\\d{2}"))
        {
        	errorCodes.put("birthdate", ERROR_BDATE_INVALID);
        	birthdate = "";
        }
        
        //Validate birthPlace
        if(birthplace.length() == 0)
        {
        	errorCodes.put("birthplace", ERROR_BPLACE_ENTER);
        	birthplace = "";
        }

        // If no errors, form is valid
        return errorCodes.size() == 0;
    }

    public boolean process() {
        if (!isValid()) {
            return false;
        }

        // Process form...
        errorCodes.clear();
        Account account = new Account();
        account.setName(firstname);
        account.setSurName(lastname);
        GregorianCalendar temp = new GregorianCalendar();
        temp.setTime(stringToDate(birthdate));
        account.setBirtDate(temp);
        account.setBirthPlace(birthplace);
        if(gender == "MALE")
        	account.setSex('m');
        else
        	account.setSex('f');
        
        //Save account object in Session bean
        userData.setAccount(account);
        
        
        return true;
    }
}
