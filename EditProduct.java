/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author omnia
 */
public class EditProduct extends HttpServlet {

    Statement stmt;
    PreparedStatement stmt2;
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
        //getting id:
        int idPara = Integer.parseInt(request.getParameter("id"));
        //respone writter
        PrintWriter pen = response.getWriter();
//        String adminLogFlag = null;
//        HttpSession sessionParameters;
//        sessionParameters = request.getSession(false);
//        if (sessionParameters != null) {
//            adminLogFlag = (String) sessionParameters.getAttribute("logInAdmin");
//            if (adminLogFlag != null && adminLogFlag.equals("true")) {

        RequestDispatcher dispatcherHeader = request.getRequestDispatcher("adminHeader.jsp");
        dispatcherHeader.include(request, response);
        ServletContext servletContext = getServletContext();
        Connection c = (Connection) servletContext.getAttribute("getConnection");
        result = DataBaseManagement.selectSingleProduct(c, idPara);
        String product_name = null;
        String product_desc = null;
        Long product_price = null;
        String product_code = null;
        String product_category = null;
        Integer product_quantity = null;
        String product_image = null;

        //getting product info
        try {
            while (result.next()) {

                product_name = result.getString("name");
                product_desc = result.getString("description");
                product_price = result.getLong("price");
                product_code = result.getString("code");
                product_category = result.getString("category");
                product_quantity = result.getInt("total_quantity");
                product_image = result.getString("image");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
System.out.println("product decription:     "+product_desc);
        pen.println("<center> <br><br>  <img src=\" "+ product_image + "\" width=\"150\" height=\"150\">\n"
                + "  <br><br>      <label style=\"font-family: Comic Sans Ms; color: #5a88ca; font-size: 2em; font-weight: bolder\" for=\"EditProductId\">Id</label>\n"
                + "      <br><br>    <span id=\"EditProductId\">" + idPara + "</span>\n"
                + "        \n"
                + "       <form>\n"
                + "     <br><br>     <label style=\"font-family: Comic Sans Ms; color: #5a88ca; font-size: 2em; font-weight: bolder\" for=\"EditProductName\">Name</label>\n"
                + "     <br><br>     <textarea rows=\"2\" cols=\"100\" id=\"EditProductName\" style=\"border-width:0px; border:none; text-align: center\"  required>" +product_name+ "</textarea>\n"
                + "        \n"
                + "    <br><br>      <label style=\"font-family: Comic Sans Ms; color: #5a88ca; font-size: 2em; font-weight: bolder\" for=\"EditProductCategory\">Category</label>\n"
                + "    <br><br>      <input type=\"text\"  id=\"EditProductCategory\" value=" + product_category + " style=\"border-width:0px; border:none; text-align: center\" required>\n"
                + "        \n"
                + "    <br><br>       <label style=\"font-family: Comic Sans Ms; color: #5a88ca; font-size: 2em; font-weight: bolder\" for=\"EditProductCode\">Code</label>\n"
                + "     <br><br>     <input type=\"text\" id=\"EditProductCode\" value=" + product_code + " style=\"border-width:0px; border:none; text-align: center\" required>\n"
                + "        \n"
                + "  <br><br>        <label style=\"font-family: Comic Sans Ms; color: #5a88ca; font-size: 2em; font-weight: bolder\" for=\"EditProductDescription\">Description</label>\n"
                + "    <br><br>      <textarea rows=\"15\" cols=\"100\" id=\"EditProductDescription\" style=\"border-width:0px; border:none; text-align: center\" required>"+product_desc+"</textarea>\n"
                + "        \n"
                + "    <br><br>      <label style=\"font-family: Comic Sans Ms; color: #5a88ca; font-size: 2em; font-weight: bolder\" for=\"EditProductPrice\">Price</label>\n"
                + "     <br><br>     <input type=\"number\" min=\"0\" id=\"EditProductPrice\" value=" + product_price + " style=\"border-width:0px; border:none; text-align: center\" required>\n"
                + "\n"
                + "      <br><br>    <label style=\"font-family: Comic Sans Ms; color: #5a88ca; font-size: 2em; font-weight: bolder\" for=\"EditProductQuantity\">Quantity</label>\n"
                + "     <br><br>     <input type=\"number\" min=\"0\" id=\"EditProductQuantity\" value=" + product_quantity + " style=\"border-width:0px; border:none; text-align: center\" required>\n"
                + "        \n"
                + "  <br><br>   <button class =\"tablebtn\">Submit</button>"
                + "     <br><br>       </form>"
                + "<center>");
        // }
//           else {
//                response.sendRedirect("SiginInPage.jsp");
//            }
//    }
//
//    
//        else {
//            response.sendRedirect("SiginInPage.jsp");
//    }
    }

}
