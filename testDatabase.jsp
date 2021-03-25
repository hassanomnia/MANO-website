<%-- 
    Document   : Search
    Created on : Mar 8, 2021, 2:40:58 PM
    Author     : Nihal
--%>

<%@page import="web.shopping.DataBaseManagement"%>
<jsp:directive.page import="java.sql.Statement"></jsp:directive.page>
<jsp:directive.page import="java.sql.Connection"></jsp:directive.page>
<jsp:directive.page import="java.sql.ResultSet"></jsp:directive.page>
    <!DOCTYPE html>
<%!
    Statement s;
    Connection c;
    ResultSet rs;
    String firstName;
    String lastName;
    String userName;
    String password;
%>
<jsp:scriptlet>
    ServletContext servletContext = getServletContext();
    c = (Connection) servletContext.getAttribute("getConnection");
    rs = DataBaseManagement.selectAllProducts(c);
    while (rs.next()) {
        firstName = rs.getString(1);
        lastName = rs.getString(2);
        userName = rs.getString(3);
        password = rs.getString(4);
</jsp:scriptlet>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>FirstName</th> 
                <th>LastName</th> 
                <th>UserName</th> 
                <th>password</th> 
            </tr>
            <tr>
                <td>
                    <jsp:scriptlet>
                        out.print(firstName);
                    </jsp:scriptlet>
                </td>
                <td>
                    <jsp:scriptlet>
                        out.print(lastName);
                    </jsp:scriptlet></td>
                <td>
                    <jsp:scriptlet>
                        out.print(userName);
                    </jsp:scriptlet></td>
                <td>
                    <jsp:scriptlet>
                        out.print(password);
                    </jsp:scriptlet>
                </td>
            </tr>
    </body>
</html>
<jsp:scriptlet>
    }
</jsp:scriptlet>
