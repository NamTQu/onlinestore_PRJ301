/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.product;

/**
 *
 * @author Admin
 */
public class GetPage extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetPage</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetPage at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int pageData = page;
        productDAO stdao = new productDAO();
        // data get from data base
        ArrayList<product> stds = stdao.getAllProduct();
        // pass data to jsp 
        int totalStudent = stds.size();
        int totalPage;
        if (totalStudent % 4== 0) {
            totalPage = totalStudent /4;
        } else {
            totalPage = totalStudent / 4 + 1;
        }
        if (page + 3 > totalPage) {
            page = totalPage - 3;
        }
        request.setAttribute("page", page);
        request.setAttribute("pageData", pageData);
        request.setAttribute("pages", totalPage);
        if (totalPage == pageData) {
            request.setAttribute("products", stds.subList((pageData - 1) * 4, stds.size()));
        } else {
            request.setAttribute("products", stds.subList((pageData - 1) * 4, pageData * 4));
        }
        request.getRequestDispatcher("view/products.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
