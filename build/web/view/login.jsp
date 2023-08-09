<%-- 
    Document   : login
    Created on : Mar 9, 2023, 8:14:37 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <a href="index.html"><img src="files/logo.png" width="125px"></a>
                </div>
                <nav>
                    <ul id="MenuItems">
                        <li><a href="home">Home</a></li>
                        <li><a href="getproduct">Product</a></li>
                            <c:if test="${sessionScope.role != null}">
                            <li><a href="bill">${sessionScope.username}</a></li>
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
                <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
            </div>    
        </div>


        <!------------ account-page --------------->



        <div class="account-page">
            <div class="container">
                <div class="row">
                    <div class="col-2">
                        <img src="files/image1.png" width="100%">
                    </div>

                    <div class="col-2">
                        <div class="form-container">
                            <div class="form-btn">
                                <span onclick="register()">Register</span>
                                <span onclick="login()">Login</span>
                                <hr id="Indicator"> 
                            </div>                                                                                                           

                            <form id="LoginForm" action="login" method="post">
                                <input name="username" type="text" placeholder="Username" >
                                <input name ="password" type="password" placeholder="Password" >
                                <h5 style="color :red">${requestScope.message}</h5>
                                <button type="submit" class="btn">Login</button>
                                <a href="">Forgot password</a>
                            </form>  

                            <form id="RegForm" action="register" method="post">
                                <input name="username" type="text" placeholder="Username">
                                <input name="email" type="email" placeholder="email">
                                <input name="password" type="text" placeholder="Password">
                                <input name="address" type="text" placeholder="Address">
                                <input name="phone_number" type="text" placeholder="Phone number">
                                <h5 style="color :red">${requestScope.register}</h5>
                                <button type="submit" class="btn">Register</button>
                            </form>    

                        </div>
                    </div>
                </div>
            </div>
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

        <!--------------js for toogle form------------>
        <script>
            var LoginForm = document.getElementById("LoginForm");
            var RegForm = document.getElementById("RegForm");
            var Indicator = document.getElementById("Indicator");

            function register() {
                RegForm.style.transform = "translateX(300px)";
                LoginForm.style.transform = "translateX(300px)";
                Indicator.style.transform = "translateX(0px)";
            }

            function login() {
                RegForm.style.transform = "translateX(0px)";
                LoginForm.style.transform = "translateX(0px)";
                Indicator.style.transform = "translateX(100px)";
            }

        </script>
    </body>
</html>
