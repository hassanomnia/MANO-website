<%-- 
    Document   : Mobiles
    Created on : Mar 26, 2021, 3:28:31 AM
    Author     : Nihal
--%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.shopping.Product"%>
<%@page import="web.shopping.DataBaseManagement"%>
<jsp:directive.page import="java.sql.Statement"></jsp:directive.page>
<jsp:directive.page import="java.sql.Connection"></jsp:directive.page>
<jsp:directive.page import="java.sql.ResultSet"></jsp:directive.page>
<jsp:include page="Header.jsp" />


<%!
    String url;
    float price;
    String name;
    ResultSet rs;
    Connection c;
    int id;
    int usrID;
    Float old_price;
    ServletContext servletContext;
    ArrayList<Product> prosucts;
    Iterator<Product> it;
    boolean found;
%>

<%
    servletContext = getServletContext();
    c = (Connection) servletContext.getAttribute("getConnection");
    prosucts = new ArrayList<Product>();
    if (request.getParameter("add-to-cart") != null) {

        session = request.getSession(false);
        session.setAttribute("id", -1);
        System.err.println("jjjj");

        usrID = (int) session.getAttribute("id");
        if (session.getAttribute("product") == null) {
            session.setAttribute("product", prosucts);
        }
        found = false;
        System.err.println(session.getAttribute("product"));
        it = ((ArrayList<Product>) session.getAttribute("product")).iterator();
        System.err.println("-------------------------------------------------");
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getID() == Integer.parseInt(request.getParameter("add-to-cart"))) {
                product.setQuantity(product.getQuantity() + 1);
                found = true;
            }
        }
        if (!found) {
            Product product = new Product(Integer.parseInt(request.getParameter("add-to-cart")), 1);
            ((ArrayList<Product>) session.getAttribute("product")).add(product);
        }
        //session.setAttribute(request.getParameter("product"), (int) session.getAttribute(request.getParameter("add-to-cart") + 1));
        it = ((ArrayList<Product>) session.getAttribute("product")).iterator();
        while (it.hasNext()) {
            Product product = it.next();
            System.err.println(product.getID() + " " + product.getQuantity());
        }
        response.sendRedirect("Mobiles?action=mobile.jsp");
    }
%>

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Mobiles</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <jsp:scriptlet>
                    rs = DataBaseManagement.selectMobiles(c, 1, 8);
                    while (rs.next()) {
                        url = rs.getString("image");
                        price = rs.getFloat("price");
                        name = rs.getString("name");
                        id = rs.getInt("product_id");
                        old_price = rs.getFloat("old_price");

            </jsp:scriptlet>

            <div class="col-md-3 col-sm-6">
                <div class="single-shop-product">
                    <div class="product-upper">
                        <img src="<%=url%>" alt="" class="mo_img">
                    </div>
                    <h2><a href="">
                            <jsp:scriptlet>
                                    out.print(name);
                            </jsp:scriptlet></a></h2>
                    <div class="product-carousel-price">
                        <ins>
                            <jsp:scriptlet>
                                    out.print("$" + price);
                            </jsp:scriptlet>
                        </ins> 
                        <%
                            if (old_price != 0) {
                        %>
                        <del>
                            <jsp:scriptlet>
                                    out.print("$" + old_price);
                            </jsp:scriptlet>
                        </del>
                        <%
                            }
                        %>
                    </div>  

                    <div class="product-option-shop">
                        <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="<%=id%>" rel="nofollow" href="Mobiles.jsp?add-to-cart=<%=id%>&action=mobile">Add to cart</a>
                    </div>                       
                </div>
            </div>

            <jsp:scriptlet>
                    }
            </jsp:scriptlet>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="product-pagination text-center">
                    <nav>
                        <ul class="pagination">
                            <li>
                                <a href="Mobiles.jsp?action=mobile" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li><a href="Mobiles.jsp?action=mobile">1</a></li>
                            <li><a href="Mobiles2.jsp?action=mobile">2</a></li>
                            <li><a href="Mobiles3.jsp?action=mobile">3</a></li>
                            <li>
                                <a href="Mobiles2.jsp?action=mobile" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>                        
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="Footer.html"/>