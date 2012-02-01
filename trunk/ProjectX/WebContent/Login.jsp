<%@ page session="true" errorPage="error.jsp" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%-- Instantiate the form validation bean and supply the error message map --%>
<%@ page import="validation.*" %>
<%@ page import="beans.*" %>
<jsp:useBean id="userdata" class="beans.SessionData" scope="session">
</jsp:useBean>
<jsp:useBean id="form" class="validation.LoginBean" scope="request">
    <jsp:setProperty name="form" property="errorMessages" value='<%= errorMap %>'/>
    <jsp:setProperty name="form" property="userData" value='<%= userdata %>'/>
</jsp:useBean>

<%
    // If process is true, attempt to validate and process the form
    if ("true".equals(request.getParameter("process"))) {
%>
        <jsp:setProperty name="form" property="*" />
<%
        // Attempt to process the form
        if (form.process()) {
            // Go to success page
            response.sendRedirect("Registered.jsp");
            return;
        }
    }
%>

<html>
<head><title>A Simple Form</title></head>
<body>

<%-- When submitting the form, resubmit to this page --%>
<form action='<%= request.getRequestURI() %>' method="POST">
    
    <%-- firstName --%>
    <font color=red><%= form.getErrorMessage("firstname") %></font><br>
    First Name: <input type="TEXT" name="firstname" value='<%= form.getFirstname() %>'>
    <br>
    
    <%-- lastName --%>
    <font color=red><%= form.getErrorMessage("lastname") %></font><br>
    Last Name: <input type="TEXT" name="lastname" value='<%= form.getLastname() %>'>
    <br>
    
    <%-- birthDate --%>
    <font color=red><%= form.getErrorMessage("birthdate") %></font><br>
	Date of Birth: <input type="TEXT" name="birthdate" value='<%= form.getBirthdate() %>'>
    <br>
    
    <%-- birthPlace --%>
    <font color=red><%= form.getErrorMessage("birthplace") %></font><br>
    Birth Place: <input type="TEXT" name="birthplace" value='<%= form.getBirthplace() %>'>
    <br>
    
    <%-- gender --%>
    <font color=red><%= form.getErrorMessage("gender") %></font><br>
    Gender:
    <select name="gender">
    	<option> MALE
    	<option> FEMALE
    </select>
    <br>

    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="process" value="true">
</form>

</body>
</html>

<%!
    // Define error messages
    java.util.Map errorMap = new java.util.HashMap();
    public void jspInit() {
        errorMap.put(LoginBean.ERROR_FNAME_ENTER, "Please enter a first name");
        errorMap.put(LoginBean.ERROR_FNAME_INVALID, "The first name is not valid");
        errorMap.put(LoginBean.ERROR_LNAME_ENTER, "Please enter a last name");
        errorMap.put(LoginBean.ERROR_LNAME_INVALID, "The last name is not valid");
        errorMap.put(LoginBean.ERROR_BDATE_ENTER, "Please enter a birth date");
        errorMap.put(LoginBean.ERROR_BDATE_INVALID, "The birthdate is not valid (dd-mm-yyyy)");
        errorMap.put(LoginBean.ERROR_BPLACE_ENTER, "Please enter a birthplace");
    }
%>