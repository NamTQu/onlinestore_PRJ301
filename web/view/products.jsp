<%-- 
    Document   : products
    Created on : Mar 7, 2023, 6:36:24 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>All products - RedStore </title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./css/style.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" 
              rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>



        <div class="container">
            <div class="navbar">
                <div class="logo">
                    <img src="files/logo.png" width="125px">
                </div>
                <nav>
                    <ul id="MenuItems">
                        <li><a href="home">Home</a></li>
                        <li><a href="getProduct">Product</a></li>
                        <c:if test="${sessionScope.role != null}">
                        <li><a href="">${sessionScope.username}</a></li>
                        </c:if>
                        <c:if test="${sessionScope.role == null}">
                        <li><a href="login">Account</a></li>
                        </c:if>
                        <c:if test="${sessionScope.role_id == 1}">
                        <li><a href="admin">Manage</a></li>
                        </c:if>
                    </ul>
                </nav>
                <a href="usercart"><img src="files/cart.png" width="30px" height="30px"></a>
                <img src="files/menu.png" class="menu-icon" onclick="menutoggle()">
            </div>

        </div>



        <div class="small-container">

            <div class="row row-2">
                <h2>All Products</h2>
                         
            </div>



            <div class="row">
                <c:forEach items="${requestScope.products}" var="o">
                    <div class="col-4">             
                        <img src="files/${o.image}" >
                        <h4>${o.title}</h4>
                        <p>${o.price} $</p>
                       
                        <a href="./productdetails?id=${o.id}" class="product-button">View product</a>   
                    </div>
                </c:forEach>
            </div>             

            <c:if test="${1!=requestScope.pageData}">
                <a href="/web/getpage?page=${requestScope.pageData-1}"> <span>Previous</span></a>
            </c:if>
            <c:forEach begin="${requestScope.page}" end="${requestScope.page+3}" var="page">
                <a href="/web/getpage?page=${page}"> <span>${page}</span></a>
            </c:forEach>
            <c:if test="${requestScope.pages!=requestScope.pageData}">
                <a href="/web/getpage?page=${requestScope.pageData+1}"> <span>Next</span></a>
            </c:if>
        </div>

        <!------------ footer -------->

        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="footer-col-1">
                        <h3> Download Our App</h3>                    
                        <p>Download App for Android and IOS mobile phone</p>
                        <div class="app-logo">
                            <img src="files/play-store.png" >
                            <img src="files/app-store.png" >
                        </div>         
                    </div>
                    <div class="footer-col-2">
                        <img src="files/logo-white.png" >
                        <p>Our Purpose Is To Sustainably Make 
                            THe Pleasure and Benefit of Sports Accessible 
                            to the many</p>
                    </div>
                    <div class="footer-col-3">
                        <h3>Useful Link</h3>
                        <ul>
                            <li>Coupons</li>
                            <li>Blog products</li>
                            <li>Return Policy</li>
                            <li>Join Affiliate</li>
                        </ul>
                    </div>
                    <div class="footer-col-4">
                        <h3>Follow us</h3>
                        <ul>
                            <li>Facebook</li>
                            <li>Twitter</li>
                            <li>Instagram</li>
                            <li>Youtube</li>
                        </ul>
                    </div>
                </div>
                <hr>
                <p class="copyright">Copyright 2020 - Easy Turtorial</p>
            </div>
        </div>


        <!---------- js for toggle menu-------->
        <script>
            var MenuItems = document.getElementById("MenuItems");

            MenuItems.style.maxHeight = "0px";

            function menutoggle() {
                if (MenuItems.style.maxHeight == "0px")
                {
                    MenuItems.style.maxHeight = "200px";
                } else
                {
                    MenuItems.style.maxHeight = "0px";
                }
            }
        </script>
    </body>
</html>
