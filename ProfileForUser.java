/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nihal
 */
public class ProfileForUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String result = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "\n"
                + "<head>\n"
                + "    <title>Page Title</title>\n"
                + "    <link rel=\"stylesheet\" href=\"//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css\">\n"
                + "    <link href='https://fonts.googleapis.com/css?family=Lato:400,300' rel='stylesheet' type='text/css'>\n"
                + "    <link rel=\"stylesheet\" href=\"css/pro.css\">\n"
                + "    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet'\n"
                + "        type='text/css'>\n"
                + "    <!-- Bootstrap -->\n"
                + "    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n"
                + "\n"
                + "    <!-- Font Awesome -->\n"
                + "    <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n"
                + "\n"
                + "    <!-- Custom CSS -->\n"
                + "    <link rel=\"stylesheet\" href=\"css/owl.carousel.css\">\n"
                + "    <link rel=\"stylesheet\" href=\"style.css\">\n"
                + "    <link rel=\"stylesheet\" href=\"css/mobile.css\">"
                + "    <link rel=\"stylesheet\" href=\"css/responsive.css\">\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "    \n"
                + "    <container>\n"
                + "        <dev class=\"first\"></dev>\n"
                + "        <h1 id=\"profile\">Profile</h1>\n"
                + "    </container>\n"
                + "    <container>\n"
                + "  \n"
                + "        <div class=\"box\">\n"
                + "            <div id=\"overlay\">\n"
                + "              <div class=\"image\">\n"
                + "                <div class=\"trick\">\n"
                + "        \n"
                + "                </div>\n"
                + "              </div>\n"
                + "        \n"
                + "<div id=\"form\">\n"
                + "<button class=\"accordion\">User Name</button>\n"
                + "<div class=\"panel\">\n"
                + "  <p style=\"background-color: #527ab3;width: 355px;margin-left: 495px;opacity: 0.7;\">Nihal_Magdy</p>\n"
                + "</div>\n"
                + "<br>\n"
                + "<button class=\"accordion\">Birthday</button>\n"
                + "<div class=\"panel\">\n"
                + "  <p>29/1/1998</p>\n"
                + "</div>\n"
                + "<br>\n"
                + "<button class=\"accordion\">Password</button>\n"
                + "<div class=\"panel\">\n"
                + "  <p>ni2911998</p>\n"
                + "</div>\n"
                + "<br>\n"
                + "<button class=\"accordion\">Job</button>\n"
                + "<div class=\"panel\">\n"
                + "  <p>Software Engineer at ITI institute</p>\n"
                + "</div>\n"
                + "<br>\n"
                + "<button class=\"accordion\">Email</button>\n"
                + "<div class=\"panel\">\n"
                + "  <p>Nihalmagdy98@gmail.com</p>\n"
                + "</div>\n"
                + "<br>\n"
                + "<button class=\"accordion\">Credit Limit</button>\n"
                + "<div class=\"panel\">\n"
                + "  <p>1000$</p>\n"
                + "</div>\n"
                + "<br>\n"
                + "<button class=\"accordion\">Address</button>\n"
                + "<div class=\"panel\">\n"
                + "  <p>Al Seka Al Hadid, Bahtim, Shubra El Kheima 2, Al Qalyubia </p>\n"
                + "</div>\n"
                + "<br>\n"
                + "<button class=\"accordion\">Interests</button>\n"
                + "<div class=\"panel\">\n"
                + "  <ul class=\"Interests\">\n"
                + "      <li class=\"Interests\">Laptops</li>\n"
                + "      <br>\n"
                + "      <li class=\"Interests\">Mobiles</li>\n"
                + "  </ul>\n"
                + "</div>\n"
                + "</div>\n"
                + "    </container>\n"
                + "<script src=\"js/toggle.js\"></script>";
        response.getWriter().println(result);
        RequestDispatcher requestFooter = request.getRequestDispatcher("Footer.html");
        requestFooter.include(request, response);
    }
}
