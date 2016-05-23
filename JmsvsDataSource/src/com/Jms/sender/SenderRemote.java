package com.Jms.sender;

import javax.ejb.Remote;
import javax.jms.JMSException;
import javax.naming.NamingException;

@Remote
public interface SenderRemote {
	public void AddText() throws JMSException, NamingException;
}
