/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.control.Multas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.MultasDaoLocal;

/**
 *
 * @author Fdieg
 */
public class MultasServlet extends HttpServlet {

    @EJB
    private MultasDaoLocal multasDao;

     

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String studentIdStr= request.getParameter("id");
            int studentId=0;
            if(studentIdStr!=null && !studentIdStr.equals(""))
                studentId=Integer.parseInt(studentIdStr);
            Multas multa=new Multas();
            multa=multasDao.getMulta(studentId);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MultasServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div  class=\"col-md-12\">\n" +"\n" +
"                                                <table border=\"2px\">\n" +"\n" +
"                                                    <tr>\n" +
"                                                        <td colspan=\"4\">Nombre Completo: "+multa.getNombre()+" </td>\n" +"\n" +"\n" +
"                                                    </tr>\n" +
"                                                    <tr>\n" +
"                                                        <td>Fecha: "+multa.getFecha()+"</td>\n" +
"                                                        <td>Valor: "+multa.getValormulta()+"</td>\n" +
"                                                        <td>Estado: "+multa.getEstado()+"</td>\n" +
"                                                    </tr>\n" +"\n" +
"                                                </table>\n" +
"                                            </div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
