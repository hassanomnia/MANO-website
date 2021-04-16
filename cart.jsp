<%-- 
    Document   : cart
    Created on : Mar 28, 2021, 9:38:33 PM
    Author     : omniahassan
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.shopping.DataBaseManagement"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="web.shopping.Product"%>
<jsp:include page="Header.jsp" />

<%
    String log = request.getParameter("check");
    ArrayList<Product> getProducts = (ArrayList<Product>) session.getAttribute("product");
%>


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
                            <form>
                                <center>
                                    <table style="table-layout: auto" cellspacing="0" class="shop_table cart">
                                        <thead>
                                            <tr>
                                                <th class="product-remove">&nbsp;</th>
                                                <th class="product-thumbnail">&nbsp;</th>
                                                <th class="product-name">Product</th>
                                                <th class="product-price">Price</th>
                                                <th width="200" class="product-quantity">Quantity</th>
                                                <th class="product-subtotal">Total</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <%
                                                ResultSet productInfo;
                                                //getting data base connection:
                                                ServletContext servletContext = getServletContext();
                                                Connection c = (Connection) servletContext.getAttribute("getConnection");
                                                if (getProducts
                                                        != null) {

                                                    for (int i = 0; i < getProducts.size(); i++) {
                                                        //System.out.println("##################" + getProducts.get(i).getID() + "            " + getProducts.get(i).getQuantity());
                                                        int productId = getProducts.get(i).getID();
                                                        int productQuantity = getProducts.get(i).getQuantity();
                                                        productInfo = DataBaseManagement.selectSingleProduct(c, productId);
                                                        while (productInfo.next()) {
                                                            String product_name = productInfo.getString("name");
                                                            Long product_price = productInfo.getLong("price");
                                                            String product_image = productInfo.getString("image");
                                                            //System.out.println("*****************" + product_name + "            " + product_price + "            " + product_image);
                                            %>
                                            <tr class="cart_item">
                                                <td class="product-remove">
                                                    <!--<a title="Remove this item" class="remove" href="#" onclick="deleteItem(this)">×</a>--> 
                                                    <input type="button" class="removebtn" value="x" onclick="location.href = 'middleCart?action=cart&check=<%=log%>&delete=<%=productId%>'">
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

<!--<input type="button" class="minus" value="-" onclick="decrement(<%=productId%>)">-->
                                                        <input type="button" class="minus" value="-" onclick="location.href = 'middleCart?action=cart&check=<%=log%>&decrement=<%=productId%>,<%=productQuantity%>'">

                                                        <input type="number" id="<%=productId%>" size="4" class="input-text qty text" title="Qty" min="0" value="<%=productQuantity%>" name="productQuantity"  oninput="calc();"> 

                                                        <!--<input type="button" class="plus" value="+" onclick="increment(<%=productId%>)">-->
                                                        <input type="button" class="plus" value="+" onclick="location.href = 'middleCart?action=cart&check=<%=log%>&increment=<%=productId%>,<%=productQuantity%>'">
                                                    </div>
                                                </td>

                                                <td class="product-subtotal">
                                                    <output id="total_<%=productId%>" name="productTotal" class="amount"></output> 
                                                </td>
                                            </tr>

                                        <input type="hidden" id="last,<%=productId%>" name="LastProducts" value="<%=productQuantity%>">



                                        <%
                                                    }
                                                }
                                            }
                                        %>
                                        <input type="hidden" name="finalSession" value="non">
                                        <tr>
                                            <td class="actions" colspan="6">
                                                <br><br><br>
                                                <div class="coupon">
                                                    <label for="coupon_code">Coupon:</label>
                                                    <input type="text" class="txtbox" placeholder="Enter Code" value="" id="coupon_code"  name="coupon_code">
                                                    <input type="button" class ="tablebtn" value="Apply Coupon" name="apply_coupon" >
                                                </div>

                                                <input type="button" class ="tablebtn"  value="Checkout" name="proceed" onclick="location.href = 'ChekOutPage.jsp?action=checkout&check=<%=log%>'" style="margin-left: 190px;">
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

        fp = document.getElementsByName("LastProducts"); //final products
        var dict = {};
        cart_subtotal = document.getElementsByName("cart-subtotal");
        order_total = document.getElementsByName("order-total");
        for (u = 0; u < t.length; u++) {
            console.log(q[u].value);
            console.log(p[u].innerText);
            console.log(parseInt(p[u].innerText));
            t[u].value = q[u].value * parseInt(p[u].innerText);

            fp[u].value = q[u].value; //final products quantites
            console.log("////// final products ********* values /////////", fp[u].value, "////// final products ********* ids /////////", fp[u].id);
            dict[fp[u].id] = fp[u].value;
            console.log(t[u].value);
            console.log("**111111111111**", cart_subtotal[0].innerText);
        }

        for (var key in dict) {
            console.log("Dictionary" + key + " : " + dict[key]);
        }

        finalSession = document.getElementsByName("finalSession")[0];
        finalSession.value = dict;
        console.log("final Session     " + finalSession.value);

        cartTotals();


    }
    function cartTotals() {
        cart_subtotal[0].innerText = 0;
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

<jsp:include page="Footer.html" />


