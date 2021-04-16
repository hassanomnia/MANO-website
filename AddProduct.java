/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nihal
 */
public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestHeader = request.getRequestDispatcher("adminHeader.jsp");
        requestHeader.include(request, response);
        String result = 
                "<br>"
                + "<img src=\"https://i.ibb.co/HVpqnTG/imageonline-co-textimage-1-1.jpg\" >"
                + "<br>"
                + "<br>"
                + "<form style=\"text-align:center;font-family:Comic Sans MS;font-weight:550;\" action=\"AddProduct\">\n"
                + "    <p for=\"ID\" style=\"margin-top:15px\">Product ID</p>\n"
                + "    <input name=\"ID\" type=\"number\" min=0 class=\"txtbox\" style=\"text-align:center;\" required/>\n"
                + "    <p for=\"name\" style=\"margin-top:15px\">Product Name</p>\n"
                + "    <input name=\"name\" type=\"text\" class=\"txtbox\" style=\"text-align:center;\" required/>\n"
                + "<br>"
                + "<br>"
                + "    <select name=\"category\" class=\"txtbox\" required>\n"
                + "        <option selected=\"\">\n"
                + "            Select Category\n"
                + "        </option>\n"
                + "        <option value=\"Laptop\">\n"
                + "            Laptop\n"
                + "        </option>\n"
                + "        <option value=\"Mobile\">\n"
                + "            Mobile\n"
                + "        </option>\n"
                + "    </select>\n"
                + "<br>"
                + "    <p for=\"code\" style=\"margin-top:15px\">Code</p>\n"
                + "    <input name=\"code\" type=\"text\" class=\"txtbox\" style=\"text-align:center;\" required/>\n"
                + "    <p for=\"price\" style=\"margin-top:15px\">Price</p>\n"
                + "    <input name=\"price\" type=\"number\" min=0 class=\"txtbox\" style=\"text-align:center;\" required/>\n"
                + "    <p for=\"oldPrice\" style=\"margin-top:15px\">Old Price</p>\n"
                + "    <input name=\"oldPrice\" min=0 placeholder=\"If you have offer on the product\"style=\"text-align:center;\" class=\"txtbox\" type=\"number\"/>\n"
                + "    <p for=\"description\" style=\"margin-top:15px\">Description</p>\n"
                + "    <textarea name=\"description\" style=\"width:275px\"></textarea>\n"
                + "    <p for=\"quantity\" style=\"margin-top:15px\">Quantity</p>\n"
                + "    <input name=\"quantity\" type=\"number\" min=0 class=\"txtbox\" style=\"text-align:center;\" required/>\n"
                + "    <p for=\"img\" style=\"margin-top:15px\">Image URL</p>\n"
                + "    <input name=\"img\" type=\"text\" class=\"txtbox\" style=\"text-align:center;\" required/>\n"
                + "<br>"
                + "<br>"
                + "    <button class=\"btnstyle\" >Save</button>"
                + "</form>\n"
                + "<br>"
                + "</body></html>";
        response.getWriter().println(result);
        if(request.getParameter("ID")!=null){
            int id = Integer.parseInt(request.getParameter("ID"));
            System.err.println(id);
            float price = Float.parseFloat(request.getParameter("price"));
            String category = request.getParameter("category");
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String imgURL = request.getParameter("img");
            Float oldPrice = Float.parseFloat(request.getParameter("oldPrice"));
            ServletContext servletContext = getServletContext();
            Connection connection = (Connection)servletContext.getAttribute("getConnection");
            DataBaseManagement.insertProduct(connection, id, name, category, code, price, oldPrice, description, quantity, imgURL);
            response.sendRedirect("AddProduct");
        }
    }
}