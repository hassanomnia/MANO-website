<%-- 
    Document   : cart
    Created on : Mar 28, 2021, 9:38:33 PM
    Author     : omniahassan
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.shopping.DataBaseManagement"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="web.shopping.Product"%>
<jsp:include page="Header.jsp" />

<%
    ArrayList<Product> products = new ArrayList<Product>(); // Create an ArrayList object
    Product p1 = new Product(1, 5);
    Product p2 = new Product(2, 6);
    Product p3 = new Product(3, 8);
    Product p4 = new Product(4, 2);
    Product p5 = new Product(5, 3);
    products.add(p1);
    products.add(p2);
    products.add(p3);
    products.add(p4);
    products.add(p5);
    session.setAttribute("product", products);
    System.out.println("*********************************************");
    System.out.println(session.getAttribute("product"));
    System.out.println("*********************************************");
%>
<!--<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MANO-CartPage</title>

         Google Fonts 
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

         Bootstrap 
        <link rel="stylesheet" href="css/bootstrap.min.css">

         Font Awesome 
        <link rel="stylesheet" href="css/font-awesome.min.css">

         Custom CSS 
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="cart.css">

         HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries 
         WARNING: Respond.js doesn't work if you view the page via file:// 
        [if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]
    </head>
    <body>

        <div class="header-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="user-menu">
                            <ul>
                                <li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                                <li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
                                <li><a href="cart.html"><i class="fa fa-user"></i> My Cart</a></li>
                                <li><a href="checkout.html"><i class="fa fa-user"></i> Checkout</a></li>
                                <li><a href="#"><i class="fa fa-user"></i> Login</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="header-right">
                            <ul class="list-unstyled list-inline">
                                <li class="dropdown dropdown-small">
                                    <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">USD</a></li>
                                        <li><a href="#">INR</a></li>
                                        <li><a href="#">GBP</a></li>
                                    </ul>
                                </li>

                                <li class="dropdown dropdown-small">
                                    <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">English</a></li>
                                        <li><a href="#">French</a></li>
                                        <li><a href="#">German</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>  End header area 

        <div class="site-branding-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="logo">
                            <h1><a href="./"><img src="img/logo.png"></a></h1>
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <div class="shopping-item">
                            <a href="cart.html">Cart - <span class="cart-amunt">$800</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>  End site branding area 

        <div class="mainmenu-area">
            <div class="container">
                <div class="row">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div> 
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="index.html">Home</a></li>
                            <li><a href="shop.html">Shop page</a></li>
                            <li><a href="single-product.html">Single product</a></li>
                            <li class="active"><a href="cart.html">Cart</a></li>
                            <li><a href="checkout.html">Checkout</a></li>
                            <li><a href="#">Category</a></li>
                            <li><a href="#">Others</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                    </div>  
                </div>
            </div>
        </div>  End mainmenu area -->

        <div class="product-big-title-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="product-bit-title text-center">
                            <h2>Shopping Cart</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End Page title area -->


        <div class="single-product-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">

                    <div class="col-md-8">
                        <div class="product-content-right">
                            <div class="woocommerce">
                                <center>
                                    <form action="#">
                                        <center>
                                            <table cellspacing="0" class="shop_table cart">
                                                <thead>
                                                    <tr>
                                                        <th class="product-remove">&nbsp;</th>
                                                        <th class="product-thumbnail">&nbsp;</th>
                                                        <th class="product-name">Product</th>
                                                        <th class="product-price">Price</th>
                                                        <th class="product-quantity">Quantity</th>
                                                        <th class="product-subtotal">Total</th>
                                                    </tr>
                                                </thead>



                                                <tbody>
                                                    <%
                                                        ResultSet productInfo;
                                                        //getting data base connection:
                                                        ServletContext servletContext = getServletContext();
                                                        Connection c = (Connection) servletContext.getAttribute("getConnection");

                                                        ArrayList<Product> getProducts = (ArrayList<Product>) session.getAttribute("product");

                                                        for (int i = 0; i < getProducts.size(); i++) {
                                                            System.out.println("##################" + getProducts.get(i).getID() + "            " + getProducts.get(i).getQuantity());
                                                            int productId = getProducts.get(i).getID();
                                                            int productQuantity = getProducts.get(i).getQuantity();
                                                            productInfo = DataBaseManagement.selectSingleProduct(c, productId);
                                                            while (productInfo.next()) {
                                                                String product_name = productInfo.getString("name");
                                                                Long product_price = productInfo.getLong("price");
                                                                String product_image = productInfo.getString("image");
                                                                System.out.println("*****************" + product_name + "            " + product_price + "            " + product_image);
                                                    %>
                                                    <tr class="cart_item">
                                                        <td class="product-remove">
                                                            <a title="Remove this item" class="remove" href="#" onclick="deleteItem(this)">×</a> 
                                                        </td>

                                                        <td class="product-thumbnail">
                                                            <a href="#"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src= <%=product_image%>></a>
                                                        </td>

                                                        <td class="product-name">
                                                            <a href="#"><%=product_name%></a> 
                                                        </td>

                                                        <td class="product-price">
                                                            <span class="amount" name="productPrice"><%=product_price%></span> 
                                                        </td>

                                                        <td class="product-quantity">
                                                            <div class="quantity buttons_added">
                                                                <input type="button" class="minus" value="-" onclick="decrement(<%=productId%>)">


                                                                <input type="number" id="<%=productId%>" size="4" class="input-text qty text" title="Qty" min="0" value="<%=productQuantity%>" name="productQuantity"  oninput="calc();"> 
                                                                <input type="button" class="plus" value="+" onclick="increment(<%=productId%>)">



                                                            </div>
                                                        </td>

                                                        <td class="product-subtotal">
                                                            <output id="total_<%=productId%>" name="productTotal" class="amount"></output> 
                                                        </td>
                                                    </tr>



                                                    <%
                                                            }

                                                        }


                                                    %>

                                                    <tr>
                                                        <td class="actions" colspan="6">
                                                            <div class="coupon">
                                                                <label for="coupon_code">Coupon:</label>
                                                                <input type="text" placeholder="Coupon code" value="" id="coupon_code" class="input-text" name="coupon_code">
                                                                <input type="submit" value="Apply Coupon" name="apply_coupon" class="button">
                                                            </div>
                                                            <input type="submit" value="Checkout" name="proceed" class="checkout-button button alt wc-forward" style="margin-left: 190px;">
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                    </form>
                                </center>
                                <div class="cart-collaterals">


                                    <div class="cart_totals ">
                                        <h2>Cart Totals</h2>

                                        <table cellspacing="0">
                                            <tbody>
                                                <tr class="cart-subtotal" >
                                                    <th>Cart Subtotal</th>
                                                    <td><span class="amount"name="cart-subtotal">0</span></td>
                                                </tr>

                                                <tr class="shipping" >
                                                    <th>Shipping and Handling</th>
                                                    <td>Free Shipping</td>
                                                </tr>

                                                <tr class="order-total">
                                                    <th>Order Total</th>
                                                    <td><strong><span class="amount" name="order-total">0</span></strong> </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>                        
                        </div>                    
                    </div>
                </div>
            </div>
        </div>






        <script>

            calc();
            
            
            function increment(i) {

                document.getElementById(i).value++;
                calc();
                
            }

            function calc() {
                t = document.getElementsByName("productTotal");
                q = document.getElementsByName("productQuantity");
                p = document.getElementsByName("productPrice");
                cart_subtotal = document.getElementsByName("cart-subtotal");
                order_total = document.getElementsByName("order-total");
                for (u = 0; u < t.length; u++) {
                    console.log(q[u].value);
                    console.log(p[u].innerText);
                    console.log(parseInt(p[u].innerText));
                    t[u].value = q[u].value * parseInt(p[u].innerText);
                    console.log(t[u].value);
                    console.log("**111111111111**", cart_subtotal[0].innerText);
                }
                cartTotals();
            }
            function cartTotals() {
                cart_subtotal[0].innerText =0;
                for (v = 0; v < t.length; v++) {
                    cart_subtotal[0].innerText = parseInt(cart_subtotal[0].innerText) + parseInt(t[v].value);
                }
                order_total[0].innerText = cart_subtotal[0].innerText;
            }
            function decrement(i) {
                if (document.getElementById(i).value > 0) {
                    document.getElementById(i).value = document.getElementById(i).value - 1;

                    calc();
                }
            }
            function deleteItem(o) {
                var p = o.parentNode.parentNode;
                p.parentNode.removeChild(p);
                cartTotals();
            }

        </script>






        <div class="footer-top-area">
            <div class="zigzag-bottom"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="footer-about-us">
                            <h2>u<span>Stora</span></h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis sunt id doloribus vero quam laborum quas alias dolores blanditiis iusto consequatur, modi aliquid eveniet eligendi iure eaque ipsam iste, pariatur omnis sint! Suscipit, debitis, quisquam. Laborum commodi veritatis magni at?</p>
                            <div class="footer-social">
                                <a href="#" target="_blank"><i class="fa fa-facebook"></i></a>
                                <a href="#" target="_blank"><i class="fa fa-twitter"></i></a>
                                <a href="#" target="_blank"><i class="fa fa-youtube"></i></a>
                                <a href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6">
                        <div class="footer-menu">
                            <h2 class="footer-wid-title">User Navigation </h2>
                            <ul>
                                <li><a href="#">My account</a></li>
                                <li><a href="#">Order history</a></li>
                                <li><a href="#">Wishlist</a></li>
                                <li><a href="#">Vendor contact</a></li>
                                <li><a href="#">Front page</a></li>
                            </ul>                        
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6">
                        <div class="footer-menu">
                            <h2 class="footer-wid-title">Categories</h2>
                            <ul>
                                <li><a href="#">Mobile Phone</a></li>
                                <li><a href="#">Home accesseries</a></li>
                                <li><a href="#">LED TV</a></li>
                                <li><a href="#">Computer</a></li>
                                <li><a href="#">Gadets</a></li>
                            </ul>                        
                        </div>
                    </div>

                    <div class="col-md-3 col-sm-6">
                        <div class="footer-newsletter">
                            <h2 class="footer-wid-title">Newsletter</h2>
                            <p>Sign up to our newsletter and get exclusive deals you wont find anywhere else straight to your inbox!</p>
                            <div class="newsletter-form">
                                <form action="#">
                                    <input type="email" placeholder="Type your email">
                                    <input type="submit" value="Subscribe">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End footer top area -->

        <div class="footer-bottom-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="copyright">
                            <p>&copy; 2015 uCommerce. All Rights Reserved. <a href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a></p>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="footer-card-icon">
                            <i class="fa fa-cc-discover"></i>
                            <i class="fa fa-cc-mastercard"></i>
                            <i class="fa fa-cc-paypal"></i>
                            <i class="fa fa-cc-visa"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div> <!-- End footer bottom area -->

        <!-- Latest jQuery form server -->
        <script src="https://code.jquery.com/jquery.min.js"></script>

        <!-- Bootstrap JS form CDN -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <!-- jQuery sticky menu -->
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.sticky.js"></script>

        <!-- jQuery easing -->
        <script src="js/jquery.easing.1.3.min.js"></script>

        <!-- Main Script -->
        <script src="js/main.js"></script>

    </body>
</html>
