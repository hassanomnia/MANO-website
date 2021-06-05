<%-- 
    Document   : Orders
    Created on : Jun 3, 2021, 3:51:23 PM
    Author     : Mayada
--%>

<%@page import="web.shopping.DataBaseManagement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Orders</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<% 
    int id =0;
    Connection c = (Connection)getServletContext().getAttribute("getConnection");
    HttpSession sessionParameters;
    sessionParameters = request.getSession(false);
    String name = (String) sessionParameters.getAttribute("userName");
    String customerId = DataBaseManagement.getCustomerId(c, name);
    ResultSet result = DataBaseManagement.selectAllOrders(c,Integer.parseInt(customerId));
%>
<center>

                <div class="product-content-right">
                    <div class="woocommerce">

                            <h3 id="order_review_heading">Your order</h3>

                            <div id="order_review" style="position: relative;">
                                <table class="shop_table" style="width: 700px">
                                    <thead>
                                        <tr>
                                            <th class="product-name">Order ID</th>
                                            <th class="product-total">Total</th>
                                            <th class="product-name">Status</th>
                                            <th class="product-name">Date Of Order</th>
                                            <th class="product-total">Date Of Arrival</th>
                                        </tr>
                                    </thead>
                                  
                                    <tbody>
               <% 
                    int orderId;
                    float totalPrice;
                    String status;
                    String date1;
                    String date2;
                    while (result.next()) {
                    orderId = result.getInt(1);
                    totalPrice = result.getFloat(3);
                    status = result.getString(4);
                    date1 = result.getString(5);
                    date2 = result.getString(7);
               %>
                                        <tr class="cart-subtotal" >
                                            <td class="product-name" style="background-color: whitesmoke;">
                                                 <strong class="product-quantity"><%=orderId%></strong> </td>
                                            <td class="product-total">
                                                <span class="amount"><%=totalPrice%></span> </td>
                                            <td class="product-total">
                                                <span class="amount"><%=status%></span> </td>
                                            <td class="product-total">
                                                <span class="amount"><%=date1%></span> </td>
                                            <td class="product-total">
                                                <span class="amount"><%=date2%></span> </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                               
                                </table>

                          </div>
                    </div>
                </div>
</center>
<div style="margin-bottom: 100px"></div>
<jsp:include page="Footer.html" />
