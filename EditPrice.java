/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author omniahassan
 */
public class EditPrice extends HttpServlet {

    Statement stmt;
    PreparedStatement stmt2;
    ResultSet result;
    int num;
    //final String dbId;

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
        String idPara = request.getParameter("id");
        //setting hidden input //to have id even if of refreshing
        String hiddenId = idPara;
        if (request.getParameterMap().containsKey("id")) {
            hiddenId = request.getParameter("id");
        } else if (request.getParameterMap().containsKey("idForm")) {
            hiddenId = request.getParameter("idForm");
        }

        //declaring and initailizing quantity value
        String priceValue = "";
        //respone writter
        PrintWriter pen = response.getWriter();
        //HTML
          RequestDispatcher dispatcherHeader = request.getRequestDispatcher("adminHeader.jsp");
        dispatcherHeader.include(request, response);
        pen.println(
//                "<!DOCTYPE html>\n"
//                + "<!--\n"
//                + "To change this license header, choose License Headers in Project Properties.\n"
//                + "To change this template file, choose Tools | Templates\n"
//                + "and open the template in the editor.\n"
//                + "-->\n"
//                + "<html>\n"
//                + "    <head>\n"
//                + "        <meta charset=\"utf-8\">\n"
//                + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
//                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
//                + "        <title>MANO</title>\n"
//                + "\n"
//                + "        <!-- Google Fonts -->\n"
//                + "        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>\n"
//                + "        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>\n"
//                + "        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>\n"
//                + "\n"
//                + "        <!-- Bootstrap -->\n"
//                + "        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n"
//                + "\n"
//                + "        <!-- Font Awesome -->\n"
//                + "        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n"
//                + "\n"
//                + "        <!-- Custom CSS -->\n"
//                + "        <link rel=\"stylesheet\" href=\"css/owl.carousel.css\">\n"
//                + "        <link rel=\"stylesheet\" href=\"style.css\">\n"
//                + "        <link rel=\"stylesheet\" href=\"css/responsive.css\">\n"
//                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"tables.css\">"
//                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"signing.css\">"
//                + "\n"
//                + "        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n"
//                + "        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n"
//                + "        <!--[if lt IE 9]>\n"
//                + "          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n"
//                + "          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n"
//                + "        <![endif]-->\n"
//                + "    </head>\n"
//                + "    <body>\n"
//                + "\n"
//                + "\n"
//                + "\n"
//                + "<div class=\"header-area\">\n"
//                + "            <div class=\"container\">\n"
//                + "                <div class=\"row\">\n"
//                + "                    <div class=\"col-md-8\">\n"
//                + "                        <div class=\"user-menu\">\n"
//                + "                            <ul>\n"
//                + "                                <li><a href=\"index.html\"><i class=\"fa fa-user\"></i> Website</a></li>\n"
//                + "                                <!--                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i> Wishlist</a></li>-->\n"
//                + "                                <li><a href=\"signIn.html\"><i class=\"fa fa-user\"></i> Login</a></li>\n"
//                + "                            </ul>\n"
//                + "                        </div>\n"
//                + "                    </div>\n"
//                + "\n"
//                + "                </div>\n"
//                + "            </div>\n"
//                + "        </div> <!-- End header area -->"
//                + "        <div class=\"site-branding-area\">\n"
//                + "            <div class=\"container\">\n"
//                + "                <div class=\"row\">\n"
//                + "                    <div class=\"col-sm-6\">\n"
//                + "                        <div class=\"logo\">\n"
//                + "                            <h1><img src=\"basicLogo.jpeg\" style=\"width:250px;height:200px;\"></h1>\n"
//                + "                        </div>\n"
//                + "                    </div>\n"
//                + "\n"
//                + "\n"
//                + "                </div>\n"
//                + "            </div>\n"
//                + "        </div> <!-- End site branding area -->\n"
//                + "\n"
//                + "        <div class=\"mainmenu-area\">\n"
//                + "            <div class=\"container\">\n"
//                + "                <div class=\"row\">\n"
//                + "                    <div class=\"navbar-header\">\n"
//                + "                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n"
//                + "                            <span class=\"sr-only\">Toggle navigation</span>\n"
//                + "                            <span class=\"icon-bar\"></span>\n"
//                + "                            <span class=\"icon-bar\"></span>\n"
//                + "                            <span class=\"icon-bar\"></span>\n"
//                + "                        </button>\n"
//                + "                    </div> \n"
//                + "                    <div class=\"navbar-collapse collapse\">\n"
//                + "                        <ul class=\"nav navbar-nav\">\n"
//                + "                            <li><a href=\"ProductServlet\">Products</a></li>\n"
//                + "                            <li><a href=\"ProfileServlet\">Customers</a></li>\n"
//                 + "                            <li><a href=\"www.google.com\">Add New Product</a></li>\n"
//                + "<li class=\"active\"><a href=\"ProductServlet\">Edit Price</a></li>\n"
//                + "\n"
//                + "                        </ul>\n"
//                + "                    </div>  \n"
//                + "                </div>\n"
//                + "            </div>\n"
//                + "        </div> <!-- End mainmenu area -->\n"
//                +
                        "<center> <table> <tr><th style=\"padding: 15px; text-align: center;\">Product Id</th><th style=\"padding: 15px; text-align: center;\">Product Name</th><th style=\"padding: 15px; text-align: center;\">Product Price</th><th style=\"padding: 15px; text-align: center;\">Product code</th><th style=\"padding: 15px; text-align: center;\">Product category</th><th style=\"padding: 15px; text-align: center;\">Product Quantity</th><th style=\"padding: 15px; text-align: center;\"></th><th style=\"padding: 15px; text-align: center;\"></th><th style=\"padding: 15px; text-align: center;\"></th></tr>"
                + "<br><br><br> <center>\n"
                + "  <form> <input type=\"hidden\" value=\"" + hiddenId + "\" name=\"idForm\"> <input type=\"number\"  min=\"0\" class=\"txtbox\" name=\"priceValue\" placeholder=\"Enter new price here\" required>\n"
                + "     <button class=\"tablebtn\" formaction=\"EditPrice?priceValue=" + priceValue + "&idForm=" + hiddenId + "\" >Submit</button>\n"
                + "   </form><button class=\"tablebtn\" onclick=\"location.href='ProductServlet';\" >Cancel</button>\n"
                + "   </center>"
        );

        //getting data base connection:
        ServletContext servletContext = getServletContext();
        Connection c = (Connection) servletContext.getAttribute("getConnection");

        
         ResultSet retunSet;
        //Retrieving single product info
        retunSet = DataBaseManagement.selectSingleProduct(c, hiddenId);
        //diplaying produt info:
        try {
            while (retunSet.next()) {
                Integer product_id = retunSet.getInt("product_id");
                String product_name = retunSet.getString("name");
                Long product_price = retunSet.getLong("price");
                String product_code = retunSet.getString("code");
                String product_category = retunSet.getString("category");
                Integer product_quantity = retunSet.getInt("total_quantity");

                pen.println("<tr align=\"center\"> <td>" + product_id + "</td> <td>" + product_name + "</td> <td>" + product_price + "</td> <td>" + product_code + "</td><td>" + product_category + "</td><td>" + product_quantity + "</td>" + "</tr>");
            }
            pen.println("</center> </body> </html>");
        } catch (SQLException ex) {
            Logger.getLogger(EditQuantity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Check if priceValue parameter exists (needed to differ btw products page request and edit price page request)
        if (request.getParameterMap().containsKey("priceValue")) {
            priceValue = request.getParameter("priceValue");
            //if exists update in db
            if (!(priceValue.equals(""))) {
                //update product quantity:
                int j = DataBaseManagement.updatePrice(c, Integer.parseInt(hiddenId), Integer.parseInt(priceValue));
                response.sendRedirect("ProductServlet");
            }
        }

       
        pen.println("</center> </body> </html>");
    }
}