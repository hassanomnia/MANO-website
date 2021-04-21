/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.bson.Document;
import org.json.JSONObject;

/**
 *
 * @author Mayada
 */
public class Reviews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcherHeader = request.getRequestDispatcher("/Header.jsp");
        dispatcherHeader.include(request, response);

       String part1 = //"<style>\n"
//                + "\n"
//                + "    .checked {\n"
//                + "        color: orange;\n"
//                + "    }\n"
//                + "</style>"
                "<div class=\"product-big-title-area\">\n"
                + "    <div class=\"container\">\n"
                + "        <div class=\"row\">\n"
                + "            <div class=\"col-md-12\">\n"
                + "                <div class=\"product-bit-title text-center\">\n"
                + "                    <h2>Reviews</h2>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</div>";
        out.println(part1);
        
        String product_id = request.getParameter("id");
        if(product_id != null){
        String log = request.getParameter("check");
        String discount = "";
        String imag = "";
        String description = "";
        String price = "";
        String old_price = "";
        String name = "";
        String category = "";
        int id = Integer.parseInt(product_id);
        ServletContext servletContext = getServletContext();
        Connection c = (Connection) servletContext.getAttribute("getConnection");
        try {
            ResultSet result = DataBaseManagement.selectSingleProduct(c, id);
            result.next();
            imag = result.getString(8);
            description = result.getString(6);
            price = result.getString(2);
            old_price = result.getString(9);
            name = result.getString(5);
            category = result.getString(3);

            if (old_price != null && old_price.equals("0")) {
                discount = "";
            } else {
                discount = "$" + old_price;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reviews.class.getName()).log(Level.SEVERE, null, ex);
        }
        String part2 = "<div class=\"single-product-area\">\n"
                + "    <div class=\"zigzag-bottom\"></div>\n"
                + "    <div class=\"container\">\n"
                + "        <div class=\"row\">\n"
                + "            <div class=\"col-md-8\">\n"
                + "                <div class=\"product-content-right\">"
                + " <div class=\"product-breadcroumb\">\n"
                + "                        <a href=\"\">Home</a>\n"
                + "                        <a href=\"\">" + category + "</a>\n"
                + "                        <a href=\"\">" + name + "</a>\n"
                + "                    </div>\n"
                + "\n"
                + "                    <div class=\"row\">\n"
                + "                        <div class=\"col-sm-6\">\n"
                + "                            <div class=\"product-images\">\n"
                + "                                <div class=\"product-main-img\">\n"
                + "                                    <img src=" + imag + " alt=\"\">   <!--import image-->\n"
                + "                                </div>\n"
                + "\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "\n"
                + "                        <div class=\"col-sm-6\">\n"
                + "                            <div class=\"product-inner\">\n"
                + "                                <h2 class=\"product-name\">" + name + "</h2>   <!--import name-->\n"
                + "                                <div class=\"product-inner-price\">\n"
                + "                                    <ins>$" + price + "</ins> <del>" + discount + "</del>     <!--import price-->\n"
                + "                                </div>"
                + "<h2 style=\"color:grey;\">Reviews</h2><br>";
        out.println(part2);
        HttpSession sessions = request.getSession(false);
        String username = "";
        MongoDatabase database = (MongoDatabase) servletContext.getAttribute("getMongoConnection");
        MongoCollection collection = database.getCollection("reviews");
        MongoCursor<Document> cursor = collection.find(Filters.eq("productID", id)).iterator();
        
        System.out.println(cursor);
        JSONObject obj = null;
        String comment = "";
        int rate = 0;
        if(!(cursor.hasNext())){
            String noReview ="<h>No reviews for this product</h>";
            out.println(noReview);
        }else{
        while (cursor.hasNext()) {
                 obj = new JSONObject(cursor.next().toJson());
                 comment = obj.getString("comment");   
                 rate = obj.getInt("rate"); 
                 username = obj.getString("customerName"); 
                 String url = DataBaseManagement.getImageURL(c, username);
                 System.out.println(rate);
                 System.out.println(comment);

        String part3 = 
                "<div>"
                + "<img src=\""+url+"\"style=\"width:30px;height:30px;\">"
                + "<i style=\"margin-left: 10px;\">"+username+"</i>"
                + ""
                + "</div>";
        String part4 = "";
        if (rate == 1) {
            part4 = " <div class=\"rating-wrap-post\" style=\"margin-left: 40px;margin-top=5px;\">\n"
                    + "                                                         \n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                        </div>";
        } else if (rate == 2) {
            part4 = " <div class=\"rating-wrap-post\" style=\"margin-left: 40px;margin-top=5px;\">\n"
                    + "                                                         \n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                        </div>";
        } else if (rate == 3) {
            part4 = " <div class=\"rating-wrap-post\" style=\"margin-left: 40px;margin-top=5px;\">\n"
                    + "                                                         \n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                        </div>";
        } else if (rate == 4) {
            part4 = " <div class=\"rating-wrap-post\" style=\"margin-left: 40px;margin-top=5px;\">\n"
                    + "                                                         \n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-starchecked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star\" value=\"0\"></span>\n"
                    + "                                                        </div>";
        } else if (rate == 5) {
            part4 = " <div class=\"rating-wrap-post\" style=\"margin-left: 40px;margin-top=5px;\">\n"
                    + "                                                         \n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                            <span name=\"s1\" class=\"fa fa-star checked\" value=\"0\"></span>\n"
                    + "                                                        </div>";
        }

        String part5 = "<div style=\"margin-left: 40px; margin-top:5px;width:300px;\">"+comment+"</div>"
                + "<br><br><br>"; ///description
        
        out.println(part3);
        out.println(part4);
        out.println(part5);
        }}}
        else{
            String noID = "<center><p style=\"color:red;margin-top:15px;\">Please choose product to show reviews</p></center><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>";
            out.println(noID);
        }        

        String part6 = "    </div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>"
                + "</div>";
        
        
        out.println(part6);
        RequestDispatcher dispatcherFooter = request.getRequestDispatcher("/Footer.html");
        dispatcherFooter.include(request, response);

    }

}
