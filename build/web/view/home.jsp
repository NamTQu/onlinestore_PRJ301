<%-- 
    Document   : home
    Created on : Mar 9, 2023, 8:08:42 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./css/style.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" 
              rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="header"> 
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
                <div class="row">
                    <div class="col-2">
                        <h1>Give Your Workout <br> A New Style!</h1>
                        <p>Sucess isn't always about greatness. It's about
                            consistency. Consistent <br> hard work gains success. Greatness
                            will come.</p>
                        <a href="getproduct" class="btn">Explore Now &#8594;</a>    
                    </div>
                    <div class="col-2">
                        <img src="files/image1.png" alt="">
                    </div>
                </div>
            </div>
        </div>

        <!-------------  featured categories  --------------->

        <div class="categories">
            <div class="small-container">
                <div class="row">
                    <div class="col-3">
                        <img src="images/category-1.jpg" alt="">
                    </div>
                    <div class="col-3">
                        <img src="images/category-2.jpg" alt="">
                    </div>
                    <div class="col-3">
                        <img src="images/category-3.jpg" alt="">
                    </div>
                </div>
            </div>

        </div>

        <!-------------  featured products  --------------->
        <div class="small-container">
            <h2 class="title"> Latest Products</h2>

            <div class="row">
                <c:forEach items="${requestScope.lasted}" var="o">
                    <div class="col-4">             
                        <img src="files/${o.image}" >
                        <h4>${o.title}</h4>
                        <p>${o.price}</p>
                        <a href="./productdetails?id=${o.id}" class="product-button">View product</a>   
                    </div>
                </c:forEach>
   
            </div>

            <div class="row">
                

                

                

                
            </div>

        </div>
        <!-------- Offer ------>

        <div class="offer">
            <div class="small-container">
                <div class="row">
                    <div class="col-2">
                        <img src="files/product-15.jpg" class="offer-img">
                    </div>
                    <div class="col-2">
                        <p>Exclusive Available on RedStore</p>
                        <h1>Smart Band 4</h1>
                        <small>
                            The Mi Smart Band 4 features a 39.9% larger
                            (than Mi band 3) AMOLED color full-touch display with 
                            adjustable brightness, so everything is clear as can be.
                        </small><br>
                        <a href="productdetails?id=${16}" class="btn">Buy Now &#8594;</a>
                    </div>
                </div>
            </div>
        </div>

        <!-------- testimonial ------->

        <div class="testimonial">
            <div class="small-container">
                <div class="row">
                    <div class="col-3">
                        <i class="fa fa-quote-left"></i>
                        <p> Lorem Ipsum is simply dummy text of the printing 
                            and typesetting industry. Lorem Ipsum has 
                            been the industry's standard dummy text ever
                        </p>
                        <div class="rating">
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star-o" ></i>
                        </div>
                        <img src="files/user-1.png" >
                        <h3>Sean Paker</h3>
                    </div>

                    <div class="col-3">
                        <i class="fa fa-quote-left"></i>
                        <p> Lorem Ipsum is simply dummy text of the printing 
                            and typesetting industry. Lorem Ipsum has 
                            been the industry's standard dummy text ever
                        </p>
                        <div class="rating">
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star-o" ></i>
                        </div>
                        <img src="files/user-2.png" >
                        <h3>Sean Paker</h3>
                    </div>

                    <div class="col-3">
                        <i class="fa fa-quote-left"></i>
                        <p> Lorem Ipsum is simply dummy text of the printing 
                            and typesetting industry. Lorem Ipsum has 
                            been the industry's standard dummy text ever
                        </p>
                        <div class="rating">
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star" ></i>
                            <i class="fa fa-star-o" ></i>
                        </div>
                        <img src="files/user-3.png" >
                        <h3>Sean Paker</h3>
                    </div>
                </div>
            </div>
        </div>

        <!-------- brands -------->

        <div class="brands">
            <div class="small-container">
                <div class="row">
                    <div class="col-5">
                        <a href="https://www.godrej.com/"><img src="files/logo-godrej.png"></a>
                    </div>
                    <div class="col-5">
                        <a href="https://www.oppo.com/en/"><img src="files/logo-oppo.png" ></a>
                    </div>
                    <div class="col-5">
                        <a href="https://www.coca-colacompany.com/"><img src="files/logo-coca-cola.png" ></a>
                    </div>
                    <div class="col-5">
                        <a href="https://www.paypal.com/vn/home"><img src="files/logo-paypal.png" ></a>
                    </div>
                    <div class="col-5">
                        <a href="https://www.usa.philips.com/"><img src="files/logo-philips.png" ></a>
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
    </body>
</html>
