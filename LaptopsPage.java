package web.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LaptopsPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String url;
    float price;
    String name;
    ResultSet rs;
    Connection c;
    int id;
    int usrID;
    Float old_price;
    ServletContext servletContext;
    ArrayList<Product> prosucts;
    Iterator<Product> it;
    boolean found;
    servletContext = getServletContext();
    c = (Connection) servletContext.getAttribute("getConnection");
    prosucts = new ArrayList<Product>();
    if (request.getParameter("add-to-cart") != null) {

        HttpSession session = request.getSession(false);
        session.setAttribute("id", -1);
        System.err.println("jjjj");

        usrID = (int) session.getAttribute("id");
        if (session.getAttribute("product") == null) {
            session.setAttribute("product", prosucts);
        }
        found = false;
        System.err.println(session.getAttribute("product"));
        it = ((ArrayList<Product>) session.getAttribute("product")).iterator();
        System.err.println("-------------------------------------------------");
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getID() == Integer.parseInt(request.getParameter("add-to-cart"))) {
                product.setQuantity(product.getQuantity() + 1);
                found = true;
            }
        }
        if (!found) {
            Product product = new Product(Integer.parseInt(request.getParameter("add-to-cart")), 1);
            ((ArrayList<Product>) session.getAttribute("product")).add(product);
        }
        //session.setAttribute(request.getParameter("product"), (int) session.getAttribute(request.getParameter("add-to-cart") + 1));
        it = ((ArrayList<Product>) session.getAttribute("product")).iterator();
        while (it.hasNext()) {
            Product product = it.next();
            System.err.println(product.getID() + " " + product.getQuantity());
        }
        response.sendRedirect("Mobiles.jsp");
    }

        PrintWriter out = response.getWriter();
        String laptops_description;
        String discount;
        RequestDispatcher dispatcherHeader = request.getRequestDispatcher("/Header.jsp");
        dispatcherHeader.include(request, response);
        try {
            ResultSet result = DataBaseManagement.selectAllProducts(c);
            String startDiv = "<div class=\"product-big-title-area\">\n"
                    + "        <div class=\"container\">\n"
                    + "            <div class=\"row\">\n"
                    + "                <div class=\"col-md-12\">\n"
                    + "                    <div class=\"product-bit-title text-center\">\n"
                    + "                        <h2>Laptops</h2>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "    \n"
                    + "    \n"
                    + "    <div class=\"single-product-area\">\n"
                    + "        <div class=\"zigzag-bottom\"></div>\n"
                    + "        <div class=\"container\">\n"
                    + "            <div class=\"row\">";
//            response.setContentType("text/html");
            out.println(startDiv);

            while (result.next()) {
                if (result.getString(3).equals("Laptop")) {
                    id = result.getInt(1);
                    String imag = result.getString(8);
                    String description = result.getString(5);
                    price = result.getFloat(2);
                    String quantity = result.getString(7);
                    old_price = result.getFloat(9);
                    if (old_price==0) {
                        discount = "";
                    } else {
                        discount = "$" + old_price;
                    }
                    laptops_description
                            = "               <div class=\"col-md-3 col-sm-6\">"
                            + "   <div class=\"single-shop-product\" style=\"width: 300px;height: 300px;padding:10px 10px 20px 10px;\">"
                            + "                          <div class=\"product-upper\" style=\"border-style: ridge;padding:15px 10px 15px 10px\">"
                            + "<center>"
                            + "<img src=\"" + imag + "\" alt=\"\" style=\"width: 160px;height: 160px\">"
                            + " </center>"
                            + "                        </div>\n"
                            + "                        <h2><a href=\"SingleProductPage.jsp?action=single&id=" + id + "\">" + description + "</a></h2>\n"
                            + "  <div class=\"product-carousel-price\">\n"
                            + "                            <ins>$" + price + "</ins> <del>" + discount + "</del>\n"
                            + "                        </div>  \n"
                            + "                        \n"
                            + "                        <div class=\"product-option-shop\">\n"
                            + "                            <a class=\"add_to_cart_button\" data-quantity=\"1\" data-product_sku=\"\" data-product_id=\"70\" rel=\"nofollow\" href=\"LaptopsPage?add-to-cart="+id+"\">Add to cart</a>\n"
                            + "                        </div>                       \n"
                            + "                    </div>\n"
                            + "                </div>";

                    out.println(laptops_description);
                }
            }
            String closeDiv = "    </div>\n"
                    + "            \n"
                    + "   \n"
                    + "    </div>\n"
                    + "    </div>";
            out.println(closeDiv);

        } catch (SQLException ex) {
            Logger.getLogger(LaptopsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcherFooter = request.getRequestDispatcher("/Footer.html");
        dispatcherFooter.include(request, response);

    }

}