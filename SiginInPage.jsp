
<%@page import="java.sql.Connection"%>
<%@page import="web.shopping.DataBaseManagement"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Sign up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="signing.css">
    </head>
    <body style="background-image:linear-gradient(white, #5a88ca); background-size: 100% 150% ; background-repeat: no-repeat ">
        <!--    <body style="background-color: #5a88ca">-->
    <center>
        <p style="font-family:Brush Script MT; font-size: 40px; font-weight: 700;">
           <img src="https://i.ibb.co/sVFR3zK/webName.jpg" width="75px" height="75px">
            Welcome Back to  MANO Store!

        </p>
        <div class="cardHeading" style="display:inline-block; margin-right:20px;">
            <img src="https://tr2.cbsistatic.com/hub/i/r/2017/04/24/3bd1d175-2b26-409d-a9ba-c825f0852f34/resize/770x/5a46b86712f9cc2d817f5ba0b2e9d146/ecommerce.jpg" height="200px" width="240px"> 
        </div>
        <% 
        String username = request.getParameter("userName");
        String passwd = request.getParameter("Password");
        HttpSession sessionParameters;
        sessionParameters = request.getSession(false);
        
        String check = request.getParameter("fromheader");
         if (check != null && !check.equals("")) {
                if (check.equals("in")) {
                    sessionParameters.setAttribute("logInFlag", "false");
                } 
            }
         String logIn = (String) sessionParameters.getAttribute("logInFlag");
            if(logIn == null || logIn.equals("false") ){
            %>
        <div class="cardBody" style="display:inline-block; margin-left: 20px">
            <center>
                <form style="align-content: center">


                    <label style="font-family:Comic Sans MS;">User name: </label>
                    <input type="text" class="txtbox" name="userName" placeholder="Enter your user name"/>
                    <br/> <br/> <br/>
                    <label style="font-family:Comic Sans MS;">Password: </label>
                    <input type="password" class="txtbox" name="Password" placeholder="Enter your password"/>
                    <br/> <br/> <br/>
                    <input class="btnstyle" type="submit" value="Sign In" >
                </form>


            </center>
        </div>
        <br>
        <br>
        <br><br>
   
    <%
        if(username != null && passwd != null)
        {
        String customer_id = "";
        ServletContext servletContext = this.getServletContext();
        Connection c= (Connection)servletContext.getAttribute("getConnection");
        String checkFlag = DataBaseManagement.checkSiginIn(c,username, passwd);
        if(checkFlag != "false"){
          customer_id = DataBaseManagement.getCustomerId(c,username);
          sessionParameters.setAttribute("logInFlag", "true");
          sessionParameters.setAttribute("userName", username);
          sessionParameters.setAttribute("customer_id", customer_id);
        }
        if(checkFlag.equals("admin"))
        {
          response.sendRedirect("Header.jsp");
        }
        else if(checkFlag.equals("customer"))
        {
          response.sendRedirect("Header.jsp?check=in");
        }
        else if(checkFlag.equals("false"))
        {
            sessionParameters.setAttribute("logInFlag", "false");
        %>
    <center>
        <p style="color: red">username or password is wrong</p>
    </center>
    
    <% } 
}%>
     <p style="font-family:Comic Sans MS;display: inline">New to  MANO Store?</p>

        <button class="btnstyle" style="display: inline"><a href="SiginUpPage">Sign Up</a></button>
        <br>
    </center>
<%} else {%>
     <p style="color: red">You are already log in</p>
     <%}%>

</body>
</html>