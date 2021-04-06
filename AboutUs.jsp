<%-- 
    Document   : AboutUs
    Created on : Apr 6, 2021, 2:23:08 PM
    Author     : omniahassan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
 <style>
            body {
                font-family: Arial, Helvetica, sans-serif;
                margin: 0;
            }

            html {
                box-sizing: border-box;
            }

            *, *:before, *:after {
                box-sizing: inherit;
            }

            .column {
                float: left;
                width: 33.3%;
                margin-bottom: 16px;
                padding: 0 8px;
            }

            .card {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                margin: 8px;
            }

            .about-section {
                padding: 50px;
                text-align: center;
                background-color: #5a88ca;
                /*background-color: #474e5d;*/
                color: white;
            }

            .container {
                padding: 0 16px;
            }

            .container::after, .row::after {
                content: "";
                clear: both;
                display: table;
            }

            .title {
                color: grey;
            }

            .button {
                border: none;
                outline: 0;
                display: inline-block;
                padding: 8px;
                color: white;
                background-color: #000;
                text-align: center;
                cursor: pointer;
                width: 35%;
            }

            .button:hover {
                background-color: #555;
            }

            @media screen and (max-width: 650px) {
                .column {
                    width: 100%;
                    display: block;
                }
            }
        </style>
        <div class="about-section">

            <div class="beginning" style="text-align:center">
                <h1>Hi, We are MANO Store</h1>
                <p style="font-size:18px">
                    We connect people and products - opening up a world of possibility. From bracelets and backpacks to tablets and toy cars.
                    <br>
                    We give you access to everything you need and want. Our range is unparalleled, and our prices unbeatable.
                    <br>
                    Driven by smart technology, everything we do is designed to put the power directly in your hands  giving you the freedom to shop however, whenever and wherever you like.

                    <br>
                    We're trusted by millions, because we don't just deliver to your doorstep, we were born here. With  MANO_Store.com you'll always be getting a good deal  with exceptional service that makes your shopping experience as easy and seamless as possible.
                </p>
            </div>
        </div>

        
            <div style="display:inline">
                <img src="https://image.shutterstock.com/image-photo/our-mission-260nw-623386115.jpg" alt="mission"  align="left" style="  width: 700px; height: 500px;">
            </div>

            <div style="display:inline">
                <br> 

                <h2 style="display:inline"> <br>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; Our Mission</h2>
                <br><br><br>
                <p style=" margin-bottom: 100px;">
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    We aim to be Earth's most customer centric company. 
                    <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    Our mission is to continually raise the bar of the customer experience by using the internet and 

                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;technology to help consumers find, discover and  
                    <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    buy anything, and empower businesses and content creators to maximize their success.
                     <br>  <br>
                     &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                    Our Leadership Principles aren't just a pretty inspirational wall hanging.
                     <br>  <br>
 &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                These Principles work hard, just like we do.
                <br>  <br>  
                  &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  MANO Store family use them, every day, whether they're discussing ideas for new projects, deciding &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp; on the best solution for a customer's problem, or interviewing candidates. 
                <br> <br>
                 &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; It's just one of the things that makes Amazon peculiar.
                </p>
            </div>

      

       <div style="display:inline">
                <img src="corevalues.jpeg" alt="corevalues"  align="right" style="  width: 650px; height: 550px;">
            </div>

            <div style="display:inline">
           
                <h2 style="display:inline"> <br>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  Our Culture and Values</h2>
                <br> <br> 
                <p style=" margin-bottom: 100px;">
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    All participants in our ecosystem - consumers, merchants, third-party service providers and others-
                    <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    have an opportunity to prosper. 
                    <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; We believe that a strong sense of shared values enables us to maintain a common company culture 
                     &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                     and community, no matter how large we grow.<br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    Our values are fundamental to the way we operate and how we recruit, evaluate and compensate our
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                    people. Our six values are:
                   <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    1- CUSTOMERS FIRST, EMPLOYEES SECOND, SHAREHOLDERS THIRD.
                <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    2- TRUST MAKES EVERYTHING SIMPLE.
                    <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    3- CHANGE IS THE ONLY CONSTANT.
                    <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    4- TODAY’S BEST PERFORMANCE IS TOMORROW’S BASELINE.
                    <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    5-IF NOT NOW, WHEN? IF NOT ME, WHO?
                    <br> <br>
                    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    6- LIVE SERIOUSLY, WORK HAPPILY.
                
                
                </p>
            </div>
        
        
        
        <p style="text-align:center; background-color: #5a88ca  ; color: white ; font-size: 80px "> Our Team </p>
        <div class="row">
            <div class="column">
                <div class="card">
                    <img src="https://www.almuheet.net/wp-content/uploads/%D9%A2%D9%A0%D9%A1%D9%A9%D9%A1%D9%A2%D9%A0%D9%A6_%D9%A1%D9%A4%D9%A3%D9%A6%D9%A3%D9%A6-694x700.jpg" alt="Mayada" style="width:100%">
                    <div class="container">
                        <h2>Mayada Tarek</h2>
                        <p class="title">CEO & Founder</p>
                        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
                        <p>mayadatarek803@gmail.com</p>
                        <p><button class="button" onclick="location.href = 'mailto:mayadatarek803@gmail.com'" style="background-color:#5a88ca" >Contact</button></p>
                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img src="https://logos.textgiraffe.com/logos/logo-name/Nihal-designstyle-birthday-m.png" alt="Nihal" style="width:100%">
                    <div class="container">
                        <h2>Nihal Magdy</h2>
                        <p class="title">Art Director</p>
                        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
                        <p>nihalmagdy98@gmail.com</p>
                        <p><button style="background-color:#5a88ca" class="button" onclick="location.href = 'mailto:mailto:nihalmagdy98@gmail.com'">Contact</button></p>
                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img src="http://1.bp.blogspot.com/-touBHJJrxgw/VBS_a5Vs1AI/AAAAAAAAFFM/yI5XyRiC0Qc/s280/Omnia-10.jpg" alt="Omnia" style="width:100%">
                    <div class="container">
                        <h2>Omnia Hassan</h2>
                        <p class="title">Designer</p>
                        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
                        <p>omniahassan7753@gmail.com</p>
                        <p><button style="background-color:#5a88ca" class="button" onclick="location.href = 'mailto:omniahassan7753@gmail.com'" >Contact</button></p>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
