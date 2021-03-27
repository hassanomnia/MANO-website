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
import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author omniahassan
 */
public class EditQuantity extends HttpServlet {

    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    ResultSet result;
    int num;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restore_try_schema", "root", "1211212224");
            stmt = con.createStatement();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditQuantity.class.getName()).log(Level.SEVERE, null, ex);
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
        //getting id:
        String idPara = request.getParameter("id");
        //to have id even if of refreshing
        HttpSession sessionParameters;
        sessionParameters = request.getSession(true);
        sessionParameters.setAttribute("editId", idPara);
        String idField = (String) sessionParameters.getAttribute("editId");
        String id_Para = request.getParameter("idForm");
        //declaring and initailizing quantity value
        String quantityValue = "";
        //respone writter
        PrintWriter pen = response.getWriter();
        //HTML
        pen.println("<!DOCTYPE html>\n"
                + "<!--\n"
                + "To change this license header, choose License Headers in Project Properties.\n"
                + "To change this template file, choose Tools | Templates\n"
                + "and open the template in the editor.\n"
                + "-->\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta charset=\"utf-8\">\n"
                + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "        <title>Ustora Demo</title>\n"
                + "\n"
                + "        <!-- Google Fonts -->\n"
                + "        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>\n"
                + "        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>\n"
                + "        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>\n"
                + "\n"
                + "        <!-- Bootstrap -->\n"
                + "        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n"
                + "\n"
                + "        <!-- Font Awesome -->\n"
                + "        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n"
                + "\n"
                + "        <!-- Custom CSS -->\n"
                + "        <link rel=\"stylesheet\" href=\"css/owl.carousel.css\">\n"
                + "        <link rel=\"stylesheet\" href=\"style.css\">\n"
                + "        <link rel=\"stylesheet\" href=\"css/responsive.css\">\n"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"tables.css\">"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"signing.css\">"
                + "\n"
                + "        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n"
                + "        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n"
                + "        <!--[if lt IE 9]>\n"
                + "          <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n"
                + "          <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n"
                + "        <![endif]-->\n"
                + "    </head>\n"
                + "    <body>\n"
                + "\n"
                + "\n"
                + "\n"
                + "<div class=\"header-area\">\n"
                + "            <div class=\"container\">\n"
                + "                <div class=\"row\">\n"
                + "                    <div class=\"col-md-8\">\n"
                + "                        <div class=\"user-menu\">\n"
                + "                            <ul>\n"
                + "                                <li><a href=\"index.html\"><i class=\"fa fa-user\"></i> Website</a></li>\n"
                + "                                <!--                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i> Wishlist</a></li>-->\n"
                + "                                <li><a href=\"signIn.html\"><i class=\"fa fa-user\"></i> Login</a></li>\n"
                + "                            </ul>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div> <!-- End header area -->"
                + "        <div class=\"site-branding-area\">\n"
                + "            <div class=\"container\">\n"
                + "                <div class=\"row\">\n"
                + "                    <div class=\"col-sm-6\">\n"
                + "                        <div class=\"logo\">\n"
                + "                            <h1><img src=\"basicLogo.jpeg\" style=\"width:250px;height:200px;\"></h1>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "\n"
                + "\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div> <!-- End site branding area -->\n"
                + "\n"
                + "        <div class=\"mainmenu-area\">\n"
                + "            <div class=\"container\">\n"
                + "                <div class=\"row\">\n"
                + "                    <div class=\"navbar-header\">\n"
                + "                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n"
                + "                            <span class=\"sr-only\">Toggle navigation</span>\n"
                + "                            <span class=\"icon-bar\"></span>\n"
                + "                            <span class=\"icon-bar\"></span>\n"
                + "                            <span class=\"icon-bar\"></span>\n"
                + "                        </button>\n"
                + "                    </div> \n"
                + "                    <div class=\"navbar-collapse collapse\">\n"
                + "                        <ul class=\"nav navbar-nav\">\n"
                + "                            <li><a href=\"ProductServlet\">Products</a></li>\n"
                + "                            <li><a href=\"ProfileServlet\">Customers</a></li>\n"
                + "<li class=\"active\"><a href=\"ProductServlet\">Edit Quantity</a></li>\n"
                + "\n"
                + "                        </ul>\n"
                + "                    </div>  \n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div> <!-- End mainmenu area -->\n"
                + "<center> <table> <tr><th style=\"padding: 15px; text-align: left;\">Product Id</th><th style=\"padding: 15px; text-align: left;\">Product Name</th><th style=\"padding: 15px; text-align: left;\">Product Price</th><th style=\"padding: 15px; text-align: left;\">Product code</th><th style=\"padding: 15px; text-align: left;\">Product category</th><th style=\"padding: 15px; text-align: left;\">Product Quantity</th><th style=\"padding: 15px; text-align: left;\"></th><th style=\"padding: 15px; text-align: left;\"></th><th style=\"padding: 15px; text-align: left;\"></th></tr>"
                + "<br><br><br> <center>\n"
                + "  <form> <input type=\"hidden\" value=\"" + idField + "\" name=\"idForm\"> <input type=\"text\" class=\"txtbox\" name=\"quantityValue\" placeholder=\"Enter new quantity here\" required>\n"
                + "     <button class=\"tablebtn\" formaction=\"EditQuantity?quantityValue=" + quantityValue + "&idForm=" + idField+"\" >Submit</button>\n"
                + "   </form><button class=\"tablebtn\" onclick=\"location.href='ProductServlet';\" >Cancel</button>\n"
                + "   </center>"
        );
        
        //diplaying produt info:
        
        ResultSet retunSet;
        retunSet = selectProduct(idPara);

        try {

            while (retunSet.next()) {
                 Integer product_id = result.getInt("product_id");
                String product_name = result.getString("name");
                Long product_price = result.getLong("price");
                String product_code = result.getString("code");
                String product_category = result.getString("category");
                Integer product_quantity = result.getInt("total_quantity");

                pen.println("<tr> <td>" + product_id + "</td> <td>" + product_name + "</td> <td>" + product_price + "</td> <td>" + product_code + "</td><td>" + product_category + "</td><td>" + product_quantity + "</td>" + "</tr>");
                pen.println("</center> </body> </html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditQuantity.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Check if quantityValue parameter exists (needed to differ btw products page request and edit quantity page request)
        if (request.getParameterMap().containsKey("quantityValue")) {
            quantityValue = request.getParameter("quantityValue");
            //if exists update in db
            if (!(quantityValue.equals("")) ) {
                updateQuantity(id_Para, quantityValue);
                response.sendRedirect("ProductServlet");
            } 
        }

        pen.println("</center> </body> </html>");
    }

    public void updateQuantity(String id, String para) {

        try {
            // result = stmt.executeQuery("select * from product");
//CREATE TABLE product (    product_id serial primary key,    price double precision,    category text,    code text,    name text,    description text,    total_quantity integer,    image text);
            //int pId = Integer.parseInt(id);
            // int pQuant = Integer.parseInt(para);
            stmt2 = con.prepareStatement("update restore_try_schema.product set total_quantity=? where product_id=?");
            stmt2.setString(1, para);
            stmt2.setString(2, id);
            int i = stmt2.executeUpdate();
            result = stmt.executeQuery("select * from product");
        } catch (SQLException ex) {
            Logger.getLogger(EditQuantity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet selectProduct(String para) {
        try {
            //int pId = Integer.parseInt(para);
            stmt2 = con.prepareStatement("SELECT * FROM restore_try_schema.product WHERE product_id=? ");
            stmt2.setString(1, para);
            result = stmt2.executeQuery();

//CREATE TABLE product (    product_id serial primary key,    price double precision,    category text,    code text,    name text,    description text,    total_quantity integer,    image text);
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
