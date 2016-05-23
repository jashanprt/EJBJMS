package com.ServletInvoder;

import java.io.IOException;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Jms.sender.SenderRemote;

/**
 * Servlet implementation class Tester
 */
@WebServlet("/Tester")
public class Tester extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tester() {
        super();
        // TODO Auto-generated constructor stub
    }

    @EJB
    private SenderRemote rem;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.print("Servlet Started");
			rem.AddText();
			System.out.print("Servlet Ended");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			System.out.print("JMS Exception");
			e.printStackTrace();
		} catch (NamingException e) {
			System.out.print("Naming Exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
