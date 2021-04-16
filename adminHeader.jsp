<!DOCTYPE html><!--\n"
                + "To change this license header, choose License Headers in Project Properties.\n"
                + "To change this template file, choose Tools | Templates\n"
                + "and open the template in the editor.\n"
                + "-->
<%String active = request.getParameter("action");%>
<html>    
    <head> 
        <meta charset="utf-8"><meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <title>MANO-Store</title>
        <!-- Google Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css"> 
        <!-- Font Awesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">  
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" type="text/css" href="tables.css">
        <link rel="stylesheet" type="text/css" href="signing.css">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>
        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>
        <![endif]--> 
    </head>
    <body>

        <div class="header-area">     
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <div class="user-menu">
                            <ul>
                                <li><a href="index.jsp"><i class="fa fa-user"></i> Website</a></li>
                                <!--                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i> Wishlist</a></li>-->
                                <li><a href="SiginInPage.jsp"><i class="fa fa-user"></i> Login</a></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div> 
        <!-- End header area -->
        <div class="site-branding-area">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="logo">
                            <h1><img src="basicLogo.jpeg" style="width:250px;height:200px; display:inline">  </h1>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <!-- End site branding area -->
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
                         <ul class="nav navbar-nav" id="navbar">
                        <li><a href="ProductServlet?action=products" <%if (active == null || active.equals("products")) {%>style="background-color:#5a88ca; color: white"<%}%>class="links">Products</a></li>
                        <li><a href="ProfileServlet?action=customers" <%if (active != null && active.equals("customers")) {%>style="background-color:#5a88ca; color: white"<%}%>class="links">Customers</a></li>
                        <li><a href="AddProduct?action=newProduct" <%if (active != null && active.equals("newProduct")) {%>style="background-color:#5a88ca; color: white"<%}%>class="links">Add New Product</a></li>
                            
                        </ul>
                    </div>  
                </div>
            </div>
        </div> 
        <!-- End mainmenu area -->
   