package web.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LaptopsPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String laptops_description;
        String discount;
        RequestDispatcher dispatcherHeader = request.getRequestDispatcher("/Header.jsp");
        dispatcherHeader.include(request, response);
        try {
            ServletContext servletContext = getServletContext();
            Connection c = (Connection) servletContext.getAttribute("getConnection");
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
                    String id = result.getString(1);
                    String imag = result.getString(8);
                    String description = result.getString(5);
                    String price = result.getString(2);
                    String quantity = result.getString(7);
                    String old_price = result.getString(9);
                    if (old_price.equals("0")) {
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
                            + "                            <a class=\"add_to_cart_button\" data-quantity=\"1\" data-product_sku=\"\" data-product_id=\"70\" rel=\"nofollow\" href=\"/canvas/shop/?add-to-cart=70\">Add to cart</a>\n"
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
