package chatbox;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import logic.User;
import beans.MessageBean;

public class ChatBoxServlet extends HttpServlet {
	
	private List<Message> messagesList = new ArrayList<Message>();


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      Collection<MessageBean> messages = new ArrayList<MessageBean>();
      
         synchronized (this) {
        	 for( Message m : messagesList ) {
               MessageBean bean = new MessageBean(m.getSender().getUserName(), m.getComment());
               messages.add(bean);
            }
         }
      
      request.setAttribute("messages",messages);
      RequestDispatcher disp = request.getRequestDispatcher("ChatBox.jsp");
      if (disp != null) {
         disp.forward(request,response);
      }
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //String name = request.getParameter("name");
         String message = request.getParameter("message");

         synchronized (this) {
            //addStmt.setDate(1,new Date((new java.util.Date()).getTime()));
        	 User u = new User("test");
        	 Message m = new Message(u, message);
        	 System.out.println( m.getComment() );
         }
         doGet(request,response);
   }
}