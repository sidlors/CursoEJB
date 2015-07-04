/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.Future;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;

/**
 *
 * @author dchoudhu
 */
@WebServlet(name = "CalcInvokeServlet", urlPatterns = {"/CalcInvokeServlet"})
public class CalcInvokeServlet extends HttpServlet {
    @EJB
CalculatorBean calcBean;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcInvokeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalcInvokeServlet at " + request.getContextPath() + "</h1>");
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
        StringBuilder sb = new StringBuilder();

        sb.append("Begin addition calculation: " + new Date() + "<br/>");
        Future<Integer> addFuture = calcBean.asyncAdd(sb, 1, 1); 
        
        sb.append("Begin subtraction calculation: " + new Date() + "<br/>");
    Future<Integer> subtractFuture = calcBean.asyncSubtract(sb, 2, 1); 
    
    sb.append("Do some other work and wait for results from " + "asynchronous calculations." + "<br/>");
     while (!addFuture.isDone() || !subtractFuture.isDone()) {
     try {
      Thread.sleep(100);

     } catch (InterruptedException e) {
      System.out.println("Error occured while trying to make this thread asleep.");
      e.printStackTrace();
      return;
       }
     }
     request.setAttribute("message", sb.toString());
    request.getRequestDispatcher("response.jsp").forward(request, response);
     

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
