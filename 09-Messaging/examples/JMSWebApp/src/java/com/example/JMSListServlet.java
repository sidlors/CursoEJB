/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.QueueBrowser;
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
@WebServlet(name = "JMSListServlet", urlPatterns = {"/JMSListServlet"})
public class JMSListServlet extends HttpServlet {

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
                List<TextMessage> messages = new ArrayList();
        try {
            Connection connection = queueConnectionFactory.createConnection();
            Session session = connection.createSession(false, 
                                       Session.AUTO_ACKNOWLEDGE);
 	
            QueueBrowser browser = session.createBrowser(queue);
            Enumeration queueEnum = browser.getEnumeration();
            while (queueEnum.hasMoreElements()) {
                Object obj = queueEnum.nextElement();
                if(obj instanceof TextMessage) {
                    messages.add((TextMessage)obj);
                }
            }
            browser.close();
            session.close();
            connection.close();
 
            request.setAttribute("messages", messages);
            RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("jms_list.jsp");
            dispatcher.forward(request, response);
 
        } catch (JMSException ex) {
            request.setAttribute("exception", ex);
            RequestDispatcher dispatcher = 
                       request.getRequestDispatcher("jms_error.jsp");
            dispatcher.forward(request, response);
        }

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JMSListServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JMSListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
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
