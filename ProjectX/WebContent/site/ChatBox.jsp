<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>Chat it with your own personal ID</title>
<link rel="shortcut icon" href="images/favicon.ico" >
<link rel="icon" type="image/gif" href="images/chatiticon.gif" >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
</head>
<body id="page4">
<div class="tail-bottom">
  <div id="main">
    <div class="bg">


      <!-- header -->
      <div align="center" id="header">
        <ul class="site-nav">
          <li><img src="images/logobannerNew.png" class="png" alt="Chat it with your own personal ID" /></li>
        </ul>
      </div>
      
      
      <!-- menu -->
      <div align="center" id="menu">
        <ul class="site-nav">
          <li><a href="index2.html"><img src="images/register.png" class="png" alt="Chat it with your own personal ID" /></a></li>
          <li><a href="index3.html"><img src="images/login.png" class="png" alt="Chat it with your own personal ID" /></a></li>
          <li><a href="index4.html"><img src="images/chat.png" class="png" alt="Chat it with your own personal ID" /></a></li>
          <li><a href="index5.html"><img src="images/channels.png" class="png" alt="Chat it with your own personal ID" /></a></li>
          <li><a href="index6.html"><img src="images/account.png" class="png" alt="Chat it with your own personal ID" /></a></li>
          <li><a href="index7.html"><img src="images/faq.png" class="png" alt="Chat it with your own personal ID" /></a></li>
        </ul>
      </div>
      
      
      <!-- content -->
      <div id="content">
        <div class="cont-box png">
          <div class="inner">
            <div class="wrapper">
            
            
              <div class="col-1">
                <div class="title"><h1>Card ID reader</h1></div>
                 <ul class="list3 p1"> <li><img src="images/cardreader.png" alt="Cardreader" /></li>
                   </ul>
              </div>
              
              
              <div class="col-2">
                <div class="title"><h1>Chat it online</h1></div>
                    <!-- <ul class="list1 li">Chatroom :</ul> -->
                    
                    <div>
						<table>
   							<c:forEach items="${messages}" var="msg">
     							 <tr>
         							<td>${msg.name}</td>
         							<td>${msg.message}</td>
      							</tr>
   							</c:forEach>
						</table>
						<form method="POST">
							<p>Message: <br /><textarea cols='50' rows='2' name='message'></textarea> </p>
							<input type='submit' value='Versturen' />
						</form>
					</div>
                </div>
               
               
              </div>
            </div>
          </div>
        </div>


      <!-- footer -->
      <div id="footer" class="png">
           <p><a href="index.html">Chat it Productions &copy; 2012</a></p>
      </div>


    </div>
  </div>
</div>
</body>
</html>