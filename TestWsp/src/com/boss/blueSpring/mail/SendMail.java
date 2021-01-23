package com.boss.blueSpring.mail;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendMail/*")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SMTPAuthenticator smtpA = new SMTPAuthenticator();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String m_name =     request.getParameter("name");
        String m_email =    request.getParameter("email");
        String m_title =    request.getParameter("title");
        String m_text =     request.getParameter("text");

        try {
            String mail_from =  m_name + "<" + m_email + ">";
            String mail_to =    "admin<admin@83rpm.com>";
            String title =      "hosting.83rpm.com 요청사항 :: " + m_title;
            String contents =   "보낸 사람 :: " + m_name + "&lt;" + m_email + "&gt;<br><br>" + m_title + "<br><br>" + m_text;
 
            mail_from = new String(mail_from.getBytes("UTF-8"), "UTF-8");
            mail_to = new String(mail_to.getBytes("UTF-8"), "UTF-8");
 
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.auth", "true");
            
    		// 인증 번호 생성기
    		StringBuffer temp = new StringBuffer();
    		Random rnd = new Random();
    		for (int i = 0; i < 10; i++) {
    			int rIndex = rnd.nextInt(3);
    			switch (rIndex) {
    			case 0:
    				// a-z
    				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
    				break;
    			case 1:
    				// A-Z
    				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
    				break;
    			case 2:
    				// 0-9
    				temp.append((rnd.nextInt(10)));
    				break;
    			}
    		}
    		String AuthenticationKey = temp.toString();
    		System.out.println(AuthenticationKey);

    		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(smtpA.getPasswordAuthentication().getUserName(), 
    						smtpA.getPasswordAuthentication().getPassword());
    			}
    		});
            
            
            Authenticator auth = new SMTPAuthenticator();
 
            Session sess = Session.getDefaultInstance(props, auth);
 
            MimeMessage msg = new MimeMessage(sess);
 
            msg.setFrom(new InternetAddress(mail_from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail_to));
            msg.setSubject(title, "UTF-8");
            msg.setContent(contents, "text/html; charset=UTF-8");
            msg.setHeader("Content-type", "text/html; charset=UTF-8");
 
            Transport.send(msg);
 
            response.sendRedirect("request_complete.jsp");
        } catch (Exception e) {
            response.sendRedirect("request_failed.jsp");
        } finally {
 
        }
    }


	

}
