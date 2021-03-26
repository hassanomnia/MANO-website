<%-- 
    Document   : Search
    Created on : Mar 26, 2021, 8:34:10 PM
    Author     : Mayada
--%>

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
    <div style="margin: 30px 0px;padding-bottom: 60px">
    <div class="space-area1" style=" display: inline;width: 100%;font-size:medium;display: inline;">
        <h2 class="title">Search Products</h2>
        <form oninput="result.value = price.value + '$'">
        <div id=section1 style="display: inline;">
            <p class="para" style="display: inline;font-weight: bold;font-size: larger;font-family: 'Times New Roman';">Price:</p>
            <input type=range min=4000 max=200000 value=5000 class=slider name=price style="width: 300px;padding-left: 15px;display:  inline">
             <output name="result"></output>
      </div>
    </form>
</div>
    <div id="select" style="padding-left: 35%;position: relative;">
        <p class="para">Category:</p>
        <div class="custom-select"  style="width:300px;">
            <select id="list">
              <option value="0">All</option>
              <option value="1">Laptops</option>
              <option value="2">Mobiles</option>
            </select>
          </div>
    </div>
        <form style="padding-left: 900px; padding-top: 20px">
            <input type="submit" value="Search" >
        </form>
       
    </div>
 
    
<jsp:include page="Footer.html" />

