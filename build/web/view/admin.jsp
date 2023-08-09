<%-- 
    Document   : admin
    Created on : Mar 1, 2023, 10:53:09 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width-device-width. initial-scale=1.0">
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


        <!------------ admin product----------->

        <div class="admin-page">
            <div class="admin-product-form-container">
                <form action="addproduct" method="post" enctype="multipart/form-data">
                    <h3>Add new Product</h3>
                    <input type="number" placeholder="enter product quantity" name="quantity" >
                    <input type="text" placeholder="enter product title" name="title" >
                    <input type="number" placeholder="enter product price" name="price" >
                    <input type="text" placeholder="enter product description" name="description" >
                    <input type="file" accept="imgage/png, image/jpeg, image/jpg" name="image" >
                    <label for="category">Category:</label>
                    <select name="category">
                        <c:forEach items="${requestScope.category}" var="o">
                            <option value="${o.id}">${o.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" class="btn" name="add_product" value="Add product">
                </form>
            </div>
            <div class="admin-container product-page">            
                <table class="table1">
                    <tr>
                        <th>Product</th>
                        <th>Product quantity </th>
                        <th>Product name</th>
                        <th>Product price</th>
                        <th>Product description</th>                 
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${requestScope.products}" var="s">
                        <tr>
                            <td>
                                <div>
                                    <img src="files/${s.image}" class="admin"> 
                                </div>
                            </td>
                            <td>
                                <div>
                                    <p class="admin">${s.quantity}</p> 
                                </div>
                            </td>
                            <td>
                                <div>
                                    <p class="admin">${s.title}</p>
                                </div> 
                            </td>
                            <td>
                                <div>
                                    <small class="admin">${s.price}</small>
                                </div> 
                            </td>
                            <td>
                                <p>${s.description}</p>
                            </td>
                            <td>                    
                                <a href="./editproduct?id=${s.id}"  class="action-icon1"><i class="fa fa-pencil-square-o"></i>Edit</a>
                                <a href="./deleteproduct?id=${s.id}" class="action-icon2"><i class="fa fa-trash"></i>Delete</a>
                            </td>                  
                        </tr>
                    </c:forEach>
                </table>

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

        <script src="../js/main.js"></script>
    </body> 
</html>
