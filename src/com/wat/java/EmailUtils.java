package com.wat.java;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {

	private final static String sender ="810963554@qq.com";
	private final static String senderVerfirycode ="smhsvgwucfmnbehi";
	
	
	public static void sendQQEmail(String reciver,String subject,String content){
		
		Properties properties = System.getProperties();
		//����Э��
		properties.put("mail.transport.protocol", "smtp");
		//
		properties.put("mail.smtp.auth", "true");
		//qq��smtp.qq.com
		properties.put("mail.smtp.host", "smtp.qq.com");
		//ssl����˿�
		properties.put("mail.smtp.socketFactory.port", 465);//465
		//�����Ƿ�ʹ��ssl��ȫ����
		properties.put("mail.smtp.starttls.enable","true");
		
		 Session session = Session.getDefaultInstance(properties,new Authenticator(){
		        public PasswordAuthentication getPasswordAuthentication()
		        {
		         return new PasswordAuthentication(sender, senderVerfirycode); //�������ʼ��û�������Ȩ��
		        }
		});
		 
		session.setDebug(true);
		 
		try {
			MimeMessage mes = new MimeMessage(session);
			
			mes.setFrom(new InternetAddress(sender));
			
			mes.addRecipient(Message.RecipientType.TO, new InternetAddress(reciver));
			
			mes.setSubject(subject);
			
			//mes.setText("1234");
			
			mes.setContent("<h2>������֤��Ϊ��</h2><br>"+content, "text/html;charset=utf-8");
			
			Transport.send(mes);
			System.out.println("===========Successed===========");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		sendQQEmail("810963554@qq.com", "123", "1231314");
		
	}	
}
