package com.Jms.recieve;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: Reciever
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "Reciever"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "jms/Reciever")
public class Reciever implements MessageListener {

    /**
     * Default constructor. 
     */
    public Reciever() {
        // TODO Auto-generated constructor stub
    }
    @PostConstruct
	public void testLifeCycle()
	{
		System.out.println("Post COnstruct");
	}
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	TextMessage tx=(TextMessage)message;
        try {
			System.out.println("Text Recieved "+tx.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Recieved");
			e.printStackTrace();
		}
    }

}
