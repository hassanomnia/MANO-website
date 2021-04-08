
<%@page import="web.shopping.DataBaseManagement"%>
<jsp:directive.page import="java.io.IOException"></jsp:directive.page>
<jsp:directive.page import="java.sql.Connection"></jsp:directive.page>
<jsp:directive.page import="java.sql.ResultSet"></jsp:directive.page>
<jsp:directive.page import="java.sql.SQLException"></jsp:directive.page>
<jsp:directive.page import="java.util.logging.Level"></jsp:directive.page>
<jsp:directive.page import="java.util.logging.Logger"></jsp:directive.page>
<jsp:directive.page import="javax.servlet.RequestDispatcher"></jsp:directive.page>
<jsp:directive.page import="javax.servlet.ServletContext"></jsp:directive.page>
<jsp:directive.page import="javax.servlet.ServletException"></jsp:directive.page>
<jsp:directive.page import="javax.servlet.http.HttpServlet"></jsp:directive.page>
<jsp:directive.page import="javax.servlet.http.HttpServletRequest"></jsp:directive.page>
<jsp:directive.page import="javax.servlet.http.HttpServletResponse"></jsp:directive.page>
<jsp:directive.page import="javax.servlet.http.HttpSession"></jsp:directive.page>

<jsp:include page="Header.jsp" />

<%!
    ServletContext servletContext;
    Connection c;
    ResultSet rs;
    ResultSet interests;
    int id;
%>
<%
    session = request.getSession(true);
    session.setAttribute("id", 9);
    int id = (int) session.getAttribute("id");
    servletContext = getServletContext();
    c = (Connection) servletContext.getAttribute("getConnection");
    rs = DataBaseManagement.getCustomerInfo(c, id);
    interests = DataBaseManagement.selectInterests(c, id);
    
    if (rs.next()) {
        if (request.getParameter("credit") != null) {
       DataBaseManagement.UpdateCartInfo(c, rs.getInt("customer_id"),Float.parseFloat(request.getParameter("credit").trim()));
    }
        
    }
    rs = DataBaseManagement.getCustomerInfo(c, id);
    if (rs.next()) {
%>
<container>
    <dev class=first></dev>
    <h1 id=profile>Profile</h1>
</container>
<container>

    <div class=box>
        <div id=overlay>

            <%
                out.println("<div class=\"image\" style=\"background-image: url(" + rs.getString(3) + ");\">");
            %>
            <div class=trick>         
            </div>
        </div>

        <div id=form>
            <button class=accordion>User Name</button>
            <div class=panel>
                <p style="width:355px;margin-left: 495px;font-size: 20px;">
                    <%out.print(rs.getString("username"));%>
                </p>
            </div>
            <br>
            <button class=accordion>Birthday</button>
            <div class=panel>
                <p style="width:355px;margin-left: 495px;font-size: 20px;">
                    <%out.print(rs.getString("birthday"));%>
                </p>
            </div>
            <br>
            <button class=accordion>Password</button>
            <div class=panel>
                <p style="width:355px;margin-left: 495px;font-size: 20px;">

                    <%
                        out.print(rs.getString("password"));
                    %></p>
            </div>
            <br>
            <button class=accordion>Job</button>
            <div class=panel>
                <p style="width:355px;margin-left: 495px;font-size: 20px;">
                    <%
                        out.print(rs.getString("job"));
                    %>
                </p>
            </div>
            <br>
            <button class="accordion">Email</button>
            <div class="panel">
                <p style="width: 355px;margin-left: 495px;font-size: 20px;">
                    <%
                        out.print(rs.getString("email"));
                    %>
                </p>
            </div>
            <br>
            <button class="accordion">Credit Limit</button>
            <div class="panel">
                <form>
                    <input name = "credit" style="width: 355px;font-size: 20px;text-align: center;" value="
                           <%
                               out.print(rs.getFloat("credit_info"));
                           %>
                           ">
                    <br>
                    <br>
                    <button class="tablebtn" >Save</button>
                </form>
            </div>
            <br>
            <button class="accordion">Address</button>
            <div class="panel">
                <p style="width: 355px;margin-left: 495px;font-size: 18px;">
                    <%
                        out.print(rs.getString("address"));
                    %>
                </p>
            </div>
            <br>
            <button class="accordion">Interests</button>
            <div class="panel">
                <ul class="Interests">
                    <%while (interests.next()) {%>
                    <li class=Interests>
                        <%out.print(interests.getString(2));%>
                    </li>
                    <%}%>
                </ul>
            </div>
        </div>
</container>
<%
    }
%>

<jsp:include page="Footer.html" />
