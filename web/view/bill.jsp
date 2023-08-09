<%-- 
    Document   : bill
    Created on : Mar 22, 2023, 10:58:52 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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



        <div class="container">
            <div class="navbar">
                <div class="logo">
                    <img src="files/logo.png" width="125px">
                </div>
                <nav>
                    <ul id="MenuItems">
                        <li><a href="home">Home</a></li>
                        <li><a href="getproduct">Product</a></li>

                        <c:if test="${sessionScope.role != null}">
                        <li><a href="">${sessionScope.username}</a></li>
                        </c:if>
                        <c:if test="${sessionScope.role == null}">
                        <li><a href="login">Account</a></li>
                        </c:if>
                        <c:if test="${sessionScope.role_id == 1}">
                        <li><a href="">Manage</a></li>
                        </c:if>
                    </ul>
                </nav>
               <a href="usercart"><img src="files/cart.png" width="30px" height="30px"></a>
                <img src="files/menu.png" class="menu-icon" onclick="menutoggle()">
            </div>    
        </div>


        <!-------------cart items details----------->

        <div class="small-container cart-page">
            <c:forEach items="${requestScope.bills}" var="b" varStatus="status">
                <h3>Name: ${b.name}</h1><br>
                <h3>Phone Number: ${b.phone_number}</h1><br>
                <h3>Address: ${b.address}</h1><br>
                <h3>Order Date: ${b.order_date}</h1><br>
                <table class="table2">
                    <tr>
                        <th>Product</th>
                        <th>Product Quantity</th>
                        <th>Product Price</th>
                        <th>Total</th>
                    </tr>

                    <c:forEach items="${b.listProduct}" var="o" varStatus="status">                
                        <tr>

                            <td>
                                <div class="cart-info">
                                    <div>
                                        <p>${o.title}</p>
                                    </div>
                                </div>
                            </td>
                            <td><input type="number" value="${o.num}" disabled></td>
                            <td>$ ${o.price}</td>

                            <td> 
                                $ ${o.price * o.num} 
                            </td>

                        </tr>                
                    </c:forEach>
                </table>
                <br>
                <div class="row2">
                    <div class="column">
                        <div class="total-price">

                                <table class="table2">
                                    <tr>
                                        <th colspan="2">TOTAL BILL</th>
                                    </tr>
                                    <tr>
                                        <td>Total</td>
                                        <td>$ ${b.total_price}</td>
                                    </tr>        

                                </table>
                        </div>
                    </div>    
                </div>
            </c:forEach>
            </div>
                                    
        
        <div>
            <form action="logout" method="Post">
                <button type="submit" id="logout" style="
                    display: flex;
                    border:none;
                    justify-content: center;
                    background: #ff523b;
                    color: #fff;
                    padding: 8px 30px;
                    margin: 20px auto;
                    border-radius: 30px;
                    width: 50%;
                    cursor: pointer;
                        ">Logout</button>
            </form>
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
