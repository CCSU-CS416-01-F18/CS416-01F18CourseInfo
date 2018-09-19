/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author cwilliam
 */
@WebServlet(name = "DisplayPersonSoln", urlPatterns = {"/DisplayPersonSoln"})
public class DisplayPersonSoln extends HttpServlet {

    @Resource(name="jdbc/Lect8aDB")
    DataSource dataSource;
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            Connection connection = dataSource.getConnection();
            String selectPersonSQL = "select * from person where id=?";
            PreparedStatement selectStatement = connection.prepareStatement(selectPersonSQL);
            selectStatement.setString(1, request.getParameter("id"));
            ResultSet resultSet = selectStatement.executeQuery();
            out.println("<html><body><form action=\"UpdatePersonServlet\" method=\"GET\">");
            if (resultSet.next()){
                out.println("<input type=\"hidden\" name=\"id\" value=\""+resultSet.getString("id")+"\"/>");
                out.println("<input type=\"textbox\" name=\"firstName\" value=\""+resultSet.getString("firstname")+"\"/>");
                out.println("<input type=\"textbox\" name=\"lastName\" value=\""+resultSet.getString("lastname")+"\"/>");
            }else{
                out.println("Person not found");
            }
            out.println("<input type=\"submit\" value=\"Update\" /></form></body></html>");
            resultSet.close();
            selectStatement.close();
            connection.close();
        }catch(Exception e){
            out.println("Exception occurred: "+e.getMessage());
            e.printStackTrace();
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
