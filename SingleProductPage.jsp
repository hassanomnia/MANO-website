<%-- 
    Document   : SingleProductPage
    Created on : Mar 24, 2021, 5:35:09 AM
    Author     : Mayada
--%>
<%@page import="java.sql.Connection"%>
<%@page import="web.shopping.DataBaseManagement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />


    
        <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>Shop</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>

                              <%
        String product_id = request.getParameter("id");
        if(product_id != null)
        {
    %>

    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="product-content-right">
                                          <% 
                          String discount;
                          int id = Integer.parseInt(product_id);
                          ServletContext servletContext = getServletContext();
                          Connection c = (Connection) servletContext.getAttribute("getConnection");
                          ResultSet result =DataBaseManagement.selectSingleProduct(c,id);
                          result.next();
                          String imag =result.getString(8);
                          String description =result.getString(6);
                          String price =result.getString(2);
                          String old_price = result.getString(9);
                          String name = result.getString(5);
                          String category = result.getString(3);
                          if (old_price.equals("0"))
                            discount ="";
                          else
                            discount = "$"+old_price;
                                        %>
                        <div class="product-breadcroumb">
                            <a href="">Home</a>
                            <a href=""><%=category%></a>
                            <a href=""><%=name%></a>
                        </div>

                        <div class="row">
                            <div class="col-sm-6">
                                <div class="product-images">
                                    <div class="product-main-img">
                                        <img src=<%=imag%> alt="">   <!--import image-->
                                    </div>

                                </div>
                            </div>

                            <div class="col-sm-6">
                                <div class="product-inner">
                                    <h2 class="product-name"><%=name%></h2>   <!--import name-->
                                    <div class="product-inner-price">
                                        <ins>$<%=price%></ins> <del><%=discount%></del>     <!--import price-->
                                    </div>

                                    <form action="" class="cart">
                                        <div class="quantity">
                                            <input type="number" size="4" class="input-text qty text" title="Qty"
                                                value="1" name="quantity" min="1" step="1">
                                        </div>
                                        <button class="add_to_cart_button" type="submit">Add to cart</button>
                                    </form>

                                    <div class="product-inner-category">
                                        <p>Category: <a href="">Summer</a>. Tags: <a href="">awesome</a>, <a
                                                href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>. </p>
                                    </div>

                                    <div role="tabpanel">
                                        <ul class="product-tab" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home"
                                                    role="tab" data-toggle="tab">Description</a></li>
                                            <li role="presentation"><a href="#profile" aria-controls="profile"
                                                    role="tab" data-toggle="tab">Reviews</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <h2>Product Description</h2>   <!--import description-->
                                                <p><%=description%></p>
                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="profile">
                                                <h2>Reviews</h2>
                                                <div class="submit-review">
                                                    <p><label for="name">Name</label> <input name="name" type="text">
                                                    </p>
                                                    <p><label for="email">Email</label> <input name="email"
                                                            type="email"></p>
                                                    <div class="rating-chooser">
                                                        <p>Your rating</p>

                                                        <div class="rating-wrap-post">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                    </div>
                                                    <p><label for="review">Your review</label> <textarea name="review"
                                                            id="" cols="30" rows="10"></textarea></p>
                                                    <p><input type="submit" value="Submit"></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
                                               <%
    }
else
{
    %>
    <div style="padding: 80px 0px 300px 540px">
    <h   style="color:red" style="text-align: center;">Please choose product to see it's description</h>
    </div>
    <% }  %>

<jsp:include page="Footer.html" />

