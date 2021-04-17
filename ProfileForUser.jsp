<%@page import="java.util.Vector"%>
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
<style>
    @import url(https://fonts.googleapis.com/css?family=Titillium+Web:400,700&subset=latin,latin-ext);
body
{
  margin: 0;
  padding: 0;
  text-align: center;
}

.container
{
  position: relative;
  width: 100%;
  
}
.first,
.second,
.third
{  
  width: 100%;
  height: 600px;
  margin: 0;
  display: table;
  background-size: cover;
  background-attachment: fixed;
  background-repeat: no-repeat;
}
.first
{
  padding-top: 0px;
  margin-top: -50px;
}
/* https://companieshouse.blog.gov.uk/wp-content/uploads/sites/148/2018/10/shutterstock_264768506.jpg */
.first{background-image: url(https://i.ibb.co/Y8dPjFM/cover.jpg);}  
.second{background-image: url(https://besthqwallpapers.com/Uploads/23-11-2019/112658/thumb2-neon-light-background-neon-lasers-bright-purple-background-neon-backgrounds.jpg);}


body {
    /*background: url('https://wallpaperaccess.com/full/5122314.jpg') no-repeat center center;*/
    background-color: "#fff";
    /*background-size: 1100px 700px;
    //background-position: 30%;
    //background-attachment: fixed;*/
  }
  
  
  .text {
    font-family: raleway;
    font-size: 40px;
    position: absolute center;
    text-align: center;
    padding-left: 0%;
    color: #000;
    margin-top: 43px;
  }
  
  .text1 {
    font-family: raleway;
    font-size: 21px;
    text-align: center;
    margin-top: -20px;
    color: #000;
  }
  
  .image {
    text-align: center;
    width: 200px;
    /* Container's dimensions */
    
    height: 200px;
    -webkit-border-radius: 75%;
    -moz-border-radius: 75%;
    box-shadow: 0 0 0 1px #eee;
    /*background: url("https://images.unsplash.com/reserve/ysPfhVSzSP2m629CW0mw_selfPortrait.jpg?fit=crop&fm=jpg&h=700&q=80&w=1225") center center no-repeat;*/
    background-size: cover;
    margin: auto;
    margin-top: 20px;
    margin-bottom: -30px;
    align-content: center;
  }
  
  
  
  .trick {
    display: inline-block;
    vertical-align: middle;
    height: 150px;
  }
  
  .image:hover {
    box-shadow: 0px 5px 20px .9px #3F3F3F;
  }
  
  .image:hover {
    -webkit-transform: scale(1.12);
    transform: scale(1.12);
    -webkit-transition: 1.6s ease-in-out;
    transition: 1.6s ease-in-out;
  }
  
  
  
  .trick:hover img {
    -webkit-transform: scale(1);
    transform: scale(1);
  }
  
  #overlay {
    -webkit-border-radius: 50%;
    -moz-border-radius: 50%;
    padding: 0 0 0 0;
    opacity: 1.0;
    -webkit-transition: opacity 2.25s ease;
    -moz-transition: opacity 10.25s ease;
  }
  
  #box:hover #overlay {
    opacity: 1;
  }
  
  
  
  
  
  .panel-group{
    width:350px;
    margin:auto;
    /*margin:50px 400px 50px 400px;*/
    max-width:100%;
  }
  
  .panel-heading{
    background-color:transparent !important;
  }
  
  .title{
    text-align: center;
    background-color:transparent;
    color:#000;
    font-family:lato;
    font-weight:300;
    font-size:15px;
    max-width:100%;
  }
  
  
  
  
  #accordion{
    background-color: transparent;
    max-width:100%;
    margin-bottom:200px;
  }
  
  
  
  
  
  
  
  .btn-outline {
    color: inherit;
    transition: all 1.4s;
    background-color: transparent;
  }
  /* button CSS */
  
  .btn-danger.btn-outline {
    margin-top: 9px;
    background-color: transparent;
    color: #000;
    border-color: #000;
    padding:auto;
    padding:10px 0px 10px 0px;
    margin: 1px 5px 1px 0px;
    width: 100%;
    text-align:center;
    font-family: raleway;
    font-weight: 300;
    max-width:100%;
  }
  
  
  
  
  
  
  
  .accordion {
    background-color: #5a88ca;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 30%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    transition: 0.4s;
    text-align: center;
    font-family: cursive;
  }
  
  .active, .accordion:hover {
    background-color: #527ab3; 
  }
  
  .panel {
    display: none;
 
  }
  .pa{
    background-color: #527ab3;
    overflow: hidden;
    width: 355px;
    margin-left: 495px;
    opacity: 0.7;
    position: relative;
  }
  .Interests{
    text-align: left;
    width: 355px;
    margin-left: 300px;
    font-size: 20px;
  }
  #profile{
    font-family: "Comic Sans MS";
    color: #5a88ca;
  }
  
  #form{
    padding-top: 60px;
    padding-bottom: 40px;
  }
  
  
  
  
  
  
  
  /*---------    Contact Form    ------------*/
  
  input::-webkit-input-placeholder,
  textarea::-webkit-input-placeholder {
    color: #000;
    font-size: 15px;
  }
  /* on hover placeholder */
  
  input:hover::-webkit-input-placeholder,
  textarea:hover::-webkit-input-placeholder {
    color: #fff;
    font-size: 15px;
    font-family: raleway;
  }
  
  input:hover:focus::-webkit-input-placeholder,
  textarea:hover:focus::-webkit-input-placeholder {
    color: #fff;
    font-family: raleway;
  }
  
  input:hover::-moz-placeholder,
  textarea:hover::-moz-placeholder {
    color: #fff;
    font-size: 15px;
    font-family: raleway;
  }
  
  input:hover:focus::-moz-placeholder,
  textarea:hover:focus::-moz-placeholder {
    color: #fff;
    font-family: raleway;
  }
  
  input:hover::placeholder,
  textarea:hover::placeholder {
    color: #fff;
    font-size: 15px;
    font-family: raleway;
  }
  
  input:hover:focus::placeholder,
  textarea:hover:focus::placeholder {
    color: #fff;
    font-family: raleway;
  }
  
  input:hover::placeholder,
  textarea:hover::placeholder {
    color: #fff;
    font-size: 15px;
    font-family: raleway;
  }
  
  input:hover:focus::-ms-placeholder,
  textarea:hover::focus:-ms-placeholder {
    color: #fff;
    font-family: raleway;
  }
  
  #form {
    position: relative;
    width: 100%;
    margin: 0px auto 0px auto;
    font-family: raleway;
  }
  
  input {
    font-family: raleway;
    font-size: 15px;
    width: 100%;
    height: 50px;
    padding: 0px 12px 0px 12px;
    background: transparent;
    outline: none;
    color: #726659;
    border: solid 1px #eee;
    border-bottom: none;
    transition: all 0.9s ease-in-out;
    -webkit-transition: all 0.9s ease-in-out;
    -moz-transition: all 0.9s ease-in-out;
    -ms-transition: all 0.9s ease-in-out;
  }
  
  input:hover {
    background: #ccc;
    color: #fff;
    font-family: raleway;
  }
  
  textarea {
    width: 100%;
    max-width: 100%;
    height: 110px;
    max-height: 110px;
    padding: 15px;
    background: transparent;
    outline: none;
    color: #000;
    font-family: raleway;
    font-size: 25px;
    border: solid 1px #eee;
    transition: all 0.9s ease-in-out;
    -webkit-transition: all 0.9s ease-in-out;
    -moz-transition: all 0.9s ease-in-out;
    -ms-transition: all 0.9s ease-in-out;
  }
  
  textarea:hover {
    background: #ccc;
    color: #fff;
    font-family: raleway;
  }
  
  #submit {
    width: 100%;
    padding: 0;
    font-family: raleway;
    font-size: 20px;
    color: #000;
    outline: none;
    cursor: pointer;
    border: solid 1px #eee;
    border-top: none;
    margin-bottom: 0px;
  }
  
  #submit:hover {
    color: #fff;
    background-color: #ccc;
  }
</style>



<%!
    ServletContext servletContext;
    Connection c;
    ResultSet rs;
    ResultSet interests;
    int id;
    Vector<String> checkInterests;
    String log;
%>
<%
    //session = request.getSession(false);
    //session.setAttribute("id", 9);
    log = request.getParameter("check");
    System.err.println("idddddddd"+session.getAttribute("customer_id"));
    String id_ =  (String)session.getAttribute("customer_id");
    int id = Integer.parseInt(id_);
    servletContext = getServletContext();
    System.err.println("get here4");
    c = (Connection) servletContext.getAttribute("getConnection");
    System.err.println("get here3");
    rs = DataBaseManagement.getCustomerInfo(c, id);
    System.err.println("get here2");
    interests = DataBaseManagement.selectInterests(c, id);
    System.err.println("get here1");
    checkInterests = new Vector<>();
    
    if (rs.next()) {
        if (request.getParameter("credit") != null) {
            DataBaseManagement.UpdateCartInfo(c, rs.getInt("customer_id"), Float.parseFloat(request.getParameter("credit").trim()));
        }
        if (request.getParameter("username") != null) {
            DataBaseManagement.UpdateUsernameInfo(c, rs.getInt("customer_id"), request.getParameter("username").trim());
        }
        if (request.getParameter("birthday") != null) {
            DataBaseManagement.UpdateBirthdayInfo(c, rs.getInt("customer_id"), request.getParameter("birthday").trim());
        }
        if (request.getParameter("password") != null) {
            DataBaseManagement.UpdatePasswordInfo(c, rs.getInt("customer_id"), request.getParameter("password").trim());
        }
        if (request.getParameter("job") != null) {
            DataBaseManagement.UpdateJobInfo(c, rs.getInt("customer_id"), request.getParameter("job").trim());
        }
        if (request.getParameter("email") != null) {
            DataBaseManagement.UpdateEmailInfo(c, rs.getInt("customer_id"), request.getParameter("email").trim());
        }
        if (request.getParameter("address") != null) {
            DataBaseManagement.UpdateAddressInfo(c, rs.getInt("customer_id"), request.getParameter("address").trim());
        }
       
            DataBaseManagement.UpdateInterestsInfo(c, rs.getInt("customer_id"), request.getParameter("Phones"), request.getParameter("Laptops"));
            System.err.println(request.getParameter("Phones"));
            System.err.println(request.getParameter("Laptops"));
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
                <form>
                    <input name = "username" style="width: 355px;font-size: 20px;text-align: center;" value="
                           <%
                               out.print(rs.getString("username"));
                           %>
                           ">
                    <br>
                    <br>
                    <button class="tablebtn" >Save</button>
                </form>
            </div>
            <br>
            <button class=accordion>Birthday</button>
            <div class=panel>
                <form>
                    <input name = "birthday" style="width: 355px;font-size: 20px;text-align: center;" value="
                           <%
                               out.print(rs.getString("birthday"));
                           %>
                           ">
                    <br>
                    <br>
                    <button class="tablebtn" >Save</button>
                </form>
            </div>
            <br>
            <button class=accordion>Password</button>
            <div class=panel>
                <form>
                    <input name = "password" style="width: 355px;font-size: 20px;text-align: center;" value="
                           <%
                               out.print(rs.getString("password"));
                           %>
                           ">
                    <br>
                    <br>
                    <button class="tablebtn" >Save</button>
                </form>
            </div>
            <br>
            <button class=accordion>Job</button>
            <div class=panel>
                <form>
                    <input name = "job" style="width: 355px;font-size: 20px;text-align: center;" value="
                           <%
                               out.print(rs.getString("job"));
                           %>
                           ">
                    <br>
                    <br>
                    <button class="tablebtn" >Save</button>
                </form>
            </div>
            <br>
            <button class="accordion">Email</button>
            <div class="panel">
                <form>
                    <input name = "email" style="width: 355px;font-size: 20px;text-align: center;" value="
                           <%
                               out.print(rs.getString("email"));
                           %>
                           ">
                    <br>
                    <br>
                    <button class="tablebtn" >Save</button>
                </form>
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
                <form>
                    <input name = "address" style="width: 355px;font-size: 20px;text-align: center;" value="
                           <%
                               out.print(rs.getString("address"));
                           %>
                           ">
                    <br>
                    <br>
                    <button class="tablebtn" onclick="location.href='ProfileForUser.jsp?action=profile'">Save</button>
                </form>
            </div>
            <br>
            <button class="accordion">Interests</button>
            <div class="panel">

                <form>
                    <%while (interests.next()) {
                            checkInterests.add(interests.getString(2));
                            System.err.println(interests.getString(2)+"kkkk");
                        }
                        if (checkInterests.contains("Laptops")) {
                            System.err.println("kkjj");
                    %>
                    <input type="checkbox" id="Laptops" name="Laptops" value="Laptops" checked>
                    <label for="Laptops"> Laptops</label>
                    <%
                    } else {
                    %>
                    <input type="checkbox" id="Laptops" name="Laptops" value="Laptops">
                    <label for="Laptops"> Laptops</label>
                    <%
                        }
                        if (checkInterests.contains("Phones")) {
                    %>
                    <input type="checkbox" id="Phones" name="Phones" value="Phones" checked>
                    <label for="Phones"> Phones</label>
                    <%
                    } else {
                    %>
                    <input type="checkbox" id="Phones" name="Phones" value="Phones">
                    <label for="Phones"> Phones</label>    
                    <%
                        }
                    %>
                    <br><br>
                    <button class="tablebtn" >Save</button>
                </form>
            </div>
        </div>
</container>
<%
    }
else{
    //response.sendRedirect("SiginInPage.jsp");
}
%>

<jsp:include page="Footer.html" />