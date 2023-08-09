/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.cartDAO;
import dao.orderDAO;
import dao.productDAO;
import dao.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import model.product;
import model.total;
import model.user;

/**
 *
 * @author Admin
 */
public class Order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Order at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("role") == null) {
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        } else {
            cartDAO cartdao = new cartDAO();
            orderDAO orderdao = new orderDAO();
            String username = (String) httpSession.getAttribute("username");
            int cart_id = (int) httpSession.getAttribute("cart_id");
            String name = request.getParameter("name");
            user account = (user) httpSession.getAttribute("role");
            String phone_number = account.getPhone_number();
            String address = account.getAddress();
            long millis = System.currentTimeMillis();
            java.sql.Date order_date = new java.sql.Date(millis);
            int total_price = cartdao.getTotalPrice(cart_id);
            orderdao.InsertOrder(username, name, phone_number, address, order_date, total_price);
            int order_id = orderdao.getOrder_id();
            List<Integer> product_id = cartdao.getProductID(cart_id);
            orderdao.addProduct_order(order_id, product_id);
            List<total> total = cartdao.getTotal();
            orderdao.addOrder_details(order_id, product_id, total);
            productDAO proDAO = new productDAO();
            for (int i = 0; i < product_id.size(); i++) {
                proDAO.updateQuantity(proDAO.checkProductQuan(product_id.get(i)) - cartdao.checkProduct(product_id.get(i), cart_id), product_id.get(i));
            }
            cartdao.deleteProduct_cart(cart_id, product_id);
            cartdao.deleteCart_details(cart_id, product_id);
            cartdao.updatecart(cart_id);
            response.sendRedirect("home");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
