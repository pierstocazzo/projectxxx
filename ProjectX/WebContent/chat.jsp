<%@ page session="true" import="be.belgium.eid.eidlib.*,
								be.belgium.eid.exceptions.EIDException,
								be.belgium.eid.objects.IDData"
								errorPage="error.jsp"%>
<%
String nickname = (String)session.getAttribute("nickname");
if (nickname != null && nickname.length() > 0)
{		
%>
	<HTML>
		<HEAD>
			<title>Chat ProjectXXX</title>
			<link rel="stylesheet" type="text/css" href="chat.css" media="screen" />
		</HEAD>
		<body>
			<div id="container">
				<div id="header">
					<h1>
						Chat ProjectXXX
					</h1>
				</div>
				<div id="navigation">
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Services</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>
				<div id="content">
				
					Logged in!
		
				</div>
				<div id="footer">
					Copyright © Site name, 20XX
				</div>
			</div>
		</body>
	</HTML>
<%
}
else
{
	%>
	<html>
		<head>
			<title>Chat ProjectXXX</title>
			<link rel="stylesheet" type="text/css" href="chat.css" media="screen" />
		</head>
		<body>
			<div id="container">
				<div id="header">
					<h1>
						Chat ProjectXXX
					</h1>
				</div>
				<div id="navigation">
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Services</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>
				<div id="content">
				
					<p>Insert your electronic ID cart in order to participate in the chatroom.</p>
		
				</div>
				<div id="footer">
					Copyright © Site name, 20XX
				</div>
			</div>
		</body>
	</html>
	<%
}
%>





