<%-- 
    Document   : history
    Created on : Apr 17, 2021, 12:38:32 AM
    Author     : omniahassan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="web.shopping.DataBaseManagement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="adminHeader.jsp" />
<br>
<center>
    
    <h1 style="font-family: Comic Sans Ms; color: #5a88ca">Customer: </h1>

    <%
        int userId = Integer.parseInt(request.getParameter("id"));
        ResultSet info;
        ResultSet productInfo;
        String img = "";
        String productName = "";
        String name = "";
        String product_history = "";
        String quantity_history = "";
        String date_history = "";
        String[] productHistory = new String[0];
        String[] productHistory2 = new String[0];
        String[] productHistory3 = new String[0];
        String[] quantityHistory = new String[0];
        String[] quantityHistory2 = new String[0];
        String[] quantityHistory3 = new String[0];
        String[] dateHistory = new String[0];
        String[] dateHistory2 = new String[0];
        String[] dateHistory3 = new String[0];

        //getting data base connection:
        ServletContext servletContext = getServletContext();
        Connection c = (Connection) servletContext.getAttribute("getConnection");
        info = DataBaseManagement.getCustomerInfo(c, userId);
        while (info.next()) {
            name = info.getString("username");

            product_history = info.getString("product_history");
            if (product_history != null) {
                productHistory2 = product_history.split("\\{");
                productHistory3 = productHistory2[1].split("\\}");
                productHistory = productHistory3[0].split(",");
            }
            quantity_history = info.getString("quantity_history");
            if (quantity_history != null) {
                quantityHistory2 = quantity_history.split("\\{");
                quantityHistory3 = quantityHistory2[1].split("\\}");
                quantityHistory = quantityHistory3[0].split(",");
            }
            date_history = info.getString("date_history");
            if (date_history != null) {
                System.out.println("data string" + date_history);
                dateHistory2 = date_history.split("\\{");
                dateHistory3 = dateHistory2[1].split("\\}");
                dateHistory = dateHistory3[0].split(",");
            }
        }
    %>
    <h2 style="font-family: Comic Sans Ms;"><%=name%></h2>
    <%
        if (date_history != null) {
    %>
    <h1 style="font-family: Comic Sans Ms; color: #5a88ca">History: </h1>
    <table style="border: 1px solid #6495ED; border-collapse: collapse;">
        <tr style="border: 3px solid #6495ED;">
            <th style="padding: 15px;font-family: Comic Sans Ms; border: 5px solid whitesmoke; background-color: #6495ED; text-align: center">Product</th>
            <th style="padding: 15px;font-family: Comic Sans Ms; border: 5px solid whitesmoke; background-color: #6495ED; text-align: center">Product Name</th>
            <th style="padding: 15px; font-family: Comic Sans Ms; border: 5px solid whitesmoke; background-color: #6495ED; text-align: center">Quantity</th>
            <th style="padding: 15px;font-family: Comic Sans Ms;  border: 5px solid whitesmoke; background-color: #6495ED; text-align: center">Date</th>
            <th style="padding: 15px; font-family: Comic Sans Ms; border: 5px solid whitesmoke; background-color: #6495ED; text-align: center">Time</th>
        </tr>

        <%
            int productId;
            String[] tim;

            for (int i = 0; i < dateHistory.length; i++) {

                productId = Integer.parseInt(productHistory[i + 1]);
                productInfo = DataBaseManagement.selectSingleProduct(c, productId);
                while (productInfo.next()) {
                    img = productInfo.getString("image");
                    productName = productInfo.getString("name");
                }

                tim = dateHistory[i].split(" ");
                for (String a : tim) {
                    System.out.println(a);
                }
        %>
        <tr align="center" style="border: 1px solid lightgray;">
            <td style="border: 5px solid whitesmoke;"> <img src="<%=img%> " hight="70px" width="70px"> </td>
            <td style="border: 5px solid whitesmoke;"> <%=productName%> </td>
            <td style="border: 5px solid whitesmoke;"> <%=quantityHistory[i]%> </td>
            <td style="border: 5px solid whitesmoke;"> <%=tim[0]%>" </td>
            <td style="border: 5px solid whitesmoke;"> "<%=tim[1]%> </td>


        </tr>
        <%
            }
        } else {
        %>
        <p style="background-color: #6495ED; font-size:44px; display: inline" > NO History for This User    </p>
        <%
            }
        %>

    </table>
</center> 
</body>
</html>
