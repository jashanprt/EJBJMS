package com.Jms.sender;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Session Bean implementation class Sender
 */
@Stateless
public class Sender implements SenderRemote {

	/**
	 * Default constructor.
	 */
	public Sender() {
		// TODO Auto-generated constructor stub
	}
	@Interceptors(value=com.Jms.Interceptors.Intercept.class)
	public void AddText() throws JMSException, NamingException
    {
    	System.out.print("Add Text Started");
    
    	InitialContext ctx=new InitialContext();  
         QueueConnectionFactory fact=(QueueConnectionFactory)ctx.lookup("jms/MyFactory");  
    	QueueConnection conn=fact.createQueueConnection();
    	conn.start();
    	QueueSession sess=(QueueSession) conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);//What are arguments
    	Queue q=(Queue)ctx.lookup("jms/Reciever");  ;//how to instantiate
    	//MessageProducer producer=sess.createProducer(fact);
    	QueueSender sender=sess.createSender(q);
    	TextMessage mess=sess.createTextMessage("Message from Sender");//new TextMessage();//How to instantiate
    	mess.setText("Or this");
    	sender.send(mess);
    	conn.close();
    	/**/
    	System.out.print("Add Text Ended");
    }
}
