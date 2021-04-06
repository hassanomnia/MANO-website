/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;
import static web.shopping.DataBaseManagement.getCustomerInfo;
import static web.shopping.DataBaseManagement.selectInterests;

/**
 *
 * @author Nihal
 */
public class ProfileForAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = 9;
        System.out.println(id);
        ServletContext servletContext = getServletContext();
        Connection c = (Connection) servletContext.getAttribute("getConnection");
        ResultSet rs;
        System.out.println("web.shopping.ProfileForUser.doGet()");
        rs = getCustomerInfo(c, id);
        ResultSet interests = selectInterests(c, id);
        String result = null;
        RequestDispatcher requestHeader = request.getRequestDispatcher("Header.jsp");
        requestHeader.include(request, response);
        try {
            if (rs.next()) {
                try {
                    result = "<container>\n"
                            + "        <dev class=\"first\"></dev>\n"
                            + "        <h1 id=\"profile\">Profile</h1>\n"
                            + "    </container>\n"
                            + "    <container>\n"
                            + "  \n"
                            + "        <div class=\"box\">\n"
                            + "            <div id=\"overlay\">\n"
                            + "              <div class=\"image\" style=\"background-image: url("+rs.getString(3)+");\">\n"
                            + "                <div class=\"trick\">\n"
                            + "        \n"
                            + "                </div>\n"
                            + "              </div>\n"
                            + "        \n"
                            + "<div id=\"form\">"
                            + "<form action=\"deletefromDb2?id="+rs.getString(1)+"\">\n"
                            + "<button class=\"accordion\">User Name</button>\n"
                            + "<div class=\"panel\">\n"
                            + "  <p style=\"width: 355px;margin-left: 495px;font-size: 20px;\">" + rs.getString("username") + "</p>\n"
                            + "</div>\n"
                            + "<br>\n"
                            + "<button class=\"accordion\">Birthday</button>\n"
                            + "<div class=\"panel\">\n"
                            + "  <p style=\"width: 355px;margin-left: 495px;font-size: 20px;\">" + rs.getString("birthday") + "</p>\n"
                            + "</div>\n"
                            + "<br>\n"
                            + "<button class=\"accordion\">Password</button>\n"
                            + "<div class=\"panel\">\n"
                            + "  <p style=\"width: 355px;margin-left: 495px;font-size: 20px;\">" + rs.getString("password") + "</p>\n"
                            + "</div>\n"
                            + "<br>\n"
                            + "<button class=\"accordion\">Job</button>\n"
                            + "<div class=\"panel\">\n"
                            + "  <p style=\"width: 355px;margin-left: 495px;font-size: 20px;\">" + rs.getString("job") + "</p>\n"
                            + "</div>\n"
                            + "<br>\n"
                            + "<button class=\"accordion\">Email</button>\n"
                            + "<div class=\"panel\">\n"
                            + "  <p style=\"width: 355px;margin-left: 495px;font-size: 20px;\">" + rs.getString("email") + "</p>\n"
                            + "</div>\n"
                            + "<br>\n"
                            + "<button class=\"accordion\">Credit Limit</button>\n"
                            + "<div class=\"panel\">\n"
                            + "  <p style=\"width: 355px;margin-left: 495px;font-size: 20px;\">" + rs.getString("credit_info") + "</p>\n"
                            + "</div>\n"
                            + "<br>\n"
                            + "<button class=\"accordion\">Address</button>\n"
                            + "<div class=\"panel\">\n"
                            + "  <p style=\"width: 355px;margin-left: 495px;font-size: 18px;\">" + rs.getString("address") + "</p>\n"
                            + "</div>\n"
                            + "<br>\n"
                            + "<button class=\"accordion\">Interests</button>\n"
                            
                            + "<div class=\"panel\">\n"
                            + "  <ul class=\"Interests\">\n";
                            while(interests.next())
                {
                    result+="<li class=\"Interests\">"+interests.getString(2)+"</li>\n";
                }
                             result+= "  </ul>\n";
                             result+="</div>\n";
                             result+= "</br>\n";
                             result+="</br>\n";
                             result+= "<button type='submit' class='tablebtn' style=\"padding-top:5px; color:black;\">Delete</button>";
                             result+= "</form>\n";
                             result+="</div>\n";
                             result+="    </container>\n";
                } catch (SQLException ex) {
                    Logger.getLogger(ProfileForUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.getWriter().println(result);
                RequestDispatcher requestFooter = request.getRequestDispatcher("Footer.html");
                requestFooter.include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
