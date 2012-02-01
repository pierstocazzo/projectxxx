<jsp:useBean id="userdata" class="beans.SessionData" scope="session">
</jsp:useBean> 
<HTML>
<BODY>
<p>You entered registered an account with the following information:</p>
<p>Name: <%= userdata.getAccount().getName() %> <%= userdata.getAccount().getSurName() %><br/>
Birthplace: <%= userdata.getAccount().getBirthPlace() %><br/>
</BODY>
</HTML>