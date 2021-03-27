/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//To delete a customer from database
package web.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author omniahassan
 */
public class deletefromDb2 extends HttpServlet {

    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    ResultSet result;
    int num;

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
        String idPara = request.getParameter("id");
        //deleteFrmDb(idPara);
         //Retrieving all products from database
        ServletContext servletContext = getServletContext();
        Connection c = (Connection) servletContext.getAttribute("getConnection");
        DataBaseManagement.deleteProfile(c, Integer.parseInt(idPara));
        response.sendRedirect("ProfileServlet");
    }
}
