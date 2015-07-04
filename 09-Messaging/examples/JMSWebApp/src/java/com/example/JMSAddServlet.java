/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anshenoy
 */
@WebServlet("/JMSAddServlet")
public class JMSAddServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
  
    @Resource(mappedName = "jms/myQueueFactory")
    javax.jms.QueueConnectionFactory queueConnectionFactory;
    @Resource(mappedName = "jms/myQueue")
    javax.jms.Queue queue;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       String text = request.getParameter("text");
       System.out.println(text);
        try {
            Connection connection = 
                       queueConnectionFactory.createConnection();
            Session session = connection.createSession(false, 
                                         Session.AUTO_ACKNOWLEDGE);
 
            TextMessage message = session.createTextMessage(text);
            MessageProducer producer = session.createProducer(queue);
            producer.send(message);
 System.out.println("MessageProducerApp.main: sent message - " + text);

            producer.close();
            session.close();
            connection.close();
	response.sendRedirect("JMSListServlet");
 
        } catch (JMSException ex) {
            request.setAttribute("exception", ex);
            RequestDispatcher dispatcher = 
                       request.getRequestDispatcher("jms_error.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
