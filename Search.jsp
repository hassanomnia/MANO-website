<%-- 
    Document   : Search
    Created on : Mar 26, 2021, 8:34:10 PM
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
                    <h2>Search</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<%
    String price_product = request.getParameter("price");
    String category = request.getParameter("option");
    HttpSession sessionParameters = request.getSession(false);
    sessionParameters.setAttribute("priceValue", price_product);
    sessionParameters.setAttribute("categoryValue", category);
    String field1 = (String) sessionParameters.getAttribute("priceValue");
    String field2 = (String) sessionParameters.getAttribute("categoryValue");
    System.out.println(field1);
    String type = "";
%>

<form oninput="result.value = price.value + ' $'"  action="Search.jsp">   
    <div style="margin: 30px 0px;padding-bottom: 60px">
        <div class="space-area1" style=" display: inline;width: 100%;font-size:medium;display: inline;">
            <h2 class="title">Search Products</h2>

            <div id=section1 style="display: inline;">
                <p class="para" style="display: inline;font-weight: bold;font-size: larger;font-family: 'Times New Roman'; padding-left: 480px;">Price:</p>
                <input type=range min=2000 max=70000 <%if (field1 != null) {%>value=<%=field1%><%} else {%>value=5000<%}%> class=slider name="price" style="width: 300px;padding-left: 15px;display:  inline">
                <output name="result"></output>
            </div>

        </div>
        <div id="select" style="padding-left: 35%;position: relative;">
            <p class="para">Category:</p>
            <div class="custom-select"  style="width:300px;">
                <select id="list" name="option">
                    <%if (field2 == null || field2.equals("0")) {%>
                    <option value="0">All</option>
                    <option value="1">Laptops</option>
                    <option value="2">Mobiles</option>
                    <%type = "all";}%>
                    <%if (field2 != null && field2.equals("1")) {%>
                    <option value="1">Laptops</option>
                    <option value="2">Mobiles</option>
                    <option value="0">All</option>
                    <%type = "Laptop";}%>
                    <%if (field2 != null && field2.equals("2")) {%>
                    <option value="2">Mobiles</option>
                    <option value="1">Laptops</option>
                    <option value="0">All</option>
                    <% type = "Mobile";}%>
                </select>
            </div>
        </div>

        <input type="submit" value="Search" style="margin-left: 900px">
        </form>
    </div>

<%              String discount = "";
                boolean findFlag = true;
                ServletContext servletContext = getServletContext();
                Connection c = (Connection) servletContext.getAttribute("getConnection");
                if(field1 != null){
                    
               String startDiv = "<div class=\"single-product-area\">\n"
                    + "        <div class=\"zigzag-bottom\"></div>\n"
                    + "        <div class=\"container\">\n"
                    + "            <div class=\"row\">"; 
                out.println(startDiv);
                
                ResultSet result  = DataBaseManagement.searchProduct(c,type,Float.parseFloat(field1));
                String laptops_description;
                System.out.println(type);
                while (result.next()) {
                    
                    findFlag = false;
                    String id = result.getString(1);
                    String imag = result.getString(8);
                    String description = result.getString(5);
                    String price = result.getString(2);
                    String quantity = result.getString(7);
                    String old_price = result.getString(9);
                    if (old_price == null || old_price.equals("0") ) {
                        discount = "";
                    } else {
                        discount = "$" + old_price;
                    }
                    laptops_description
                            = "               <div class=\"col-md-3 col-sm-6\">"
                            + "   <div class=\"single-shop-product\" style=\"width: 300px;height: 300px;padding:10px 10px 20px 10px;\">"
                            + "                          <div class=\"product-upper\" style=\"border-style: ridge;padding:15px 10px 15px 10px\">"
                            + "<center>"
                            + "<img src=\"" + imag + "\" alt=\"\" style=\"width: 160px;height: 160px\">"
                            + " </center>"
                            + "                        </div>\n"
                            + "                        <h2><a href=\"SingleProductPage.jsp?action=single&id=" + id + "\">" + description + "</a></h2>\n"
                            + "  <div class=\"product-carousel-price\">\n"
                            + "                            <ins>$" + price + "</ins> <del>" + discount + "</del>\n"
                            + "                        </div>  \n"
                            + "                        \n"
                            + "                        <div class=\"product-option-shop\">\n"
                            + "                            <a class=\"add_to_cart_button\" data-quantity=\"1\" data-product_sku=\"\" data-product_id=\"70\" rel=\"nofollow\" href=\"/canvas/shop/?add-to-cart=70\">Add to cart</a>\n"
                            + "                        </div>                       \n"
                            + "                    </div>\n"
                            + "                </div>";

                    out.println(laptops_description);
                
            }
             if(findFlag){
%><center>
    <p style="color: red">There are no matching products</p>
</center>
                
<%           }
            String closeDiv = "    </div>\n"
                    + "            \n"
                    + "   \n"
                    + "    </div>\n"
                    + "    </div>";
            out.println(closeDiv);}
           
%>

    <jsp:include page="Footer.html" />

