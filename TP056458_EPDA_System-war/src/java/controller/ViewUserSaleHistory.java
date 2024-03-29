/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MySale;
import model.MySaleFacade;
import model.MyUser;
import model.MyUserFacade;

/**
 *
 * @author dzaky
 */
@WebServlet(name = "ViewUserSaleHistory", urlPatterns = {"/ViewUserSaleHistory"})
public class ViewUserSaleHistory extends HttpServlet {

    @EJB
    private MyUserFacade myUserFacade;

    @EJB
    private MySaleFacade mySaleFacade;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            MyUser user = (MyUser) session.getAttribute("user");
            String currentSale = user.getId();
            String userRole = user.getUserrole();
            String noSalesMessage = "";

            String targetPage = "CustomerSaleHistory.jsp";
            List<MySale> sales = null;

            if ("Customer".equals(userRole)) {
                sales = mySaleFacade.findSalesByCustomer(currentSale);
                noSalesMessage = "You have not made any purchases or rents!";
            } else if ("Owner".equals(userRole)) {
                targetPage = "OwnerSaleHistory.jsp";
                sales = mySaleFacade.findSalesByOwner(currentSale);
                noSalesMessage = "You have not made any sales!";
            } else if ("Admin".equals(userRole)) {
                targetPage = "AdminSaleHistory.jsp";
                sales = mySaleFacade.findAll();
                noSalesMessage = "There are currently no sales.";
            }

            if (sales == null || sales.isEmpty()) {
                request.getRequestDispatcher(targetPage).include(request, response);
                out.println("<div id=\"container\">");
                out.println(noSalesMessage);
                out.println("</div>");

            } else {
                request.getRequestDispatcher(targetPage).include(request, response);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<div id=\"container\">");
                out.println("<h3>Sale History</h3>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Sale ID</th>");
                out.println("<th>Listing ID</th>");
                out.println("<th>Property Name</th>");
                out.println("<th>Location</th>");
                out.println("<th>Description</th>");
                out.println("<th>Type</th>");
                out.println("<th>Price</th>");
                out.println("<th>Purchased From</th>");
                out.println("<th>Purchased By</th>");
                out.println("<th>Buyer Rating</th>");
                out.println("<th>Buyer Feedback</th>");
                out.println("<th>Seller Rating</th>");
                out.println("<th>Seller Feedback</th>");
                out.println("</tr>");

                for (MySale userSaleInfo : sales) {
                    out.println("<tr>");
                    out.println("<td>" + userSaleInfo.getId() + "</td>");
                    out.println("<td>" + userSaleInfo.getPropertyID() + "</td>");
                    out.println("<td>" + userSaleInfo.getPropertyName() + "</td>");
                    out.println("<td>" + userSaleInfo.getLocation() + "</td>");
                    out.println("<td>" + userSaleInfo.getDescription() + "</td>");
                    out.println("<td>" + userSaleInfo.getType() + "</td>");
                    out.println("<td>" + userSaleInfo.getPrice() + "</td>");
                    out.println("<td>" + userSaleInfo.getPurchasedFrom() + "</td>");
                    out.println("<td>" + userSaleInfo.getPurchasedBy() + "</td>");
                    out.println("<td>" + userSaleInfo.getCustomerSaleRating() + "</td>");
                    out.println("<td>" + userSaleInfo.getCustomerSaleReview() + "</td>");
                    out.println("<td>" + userSaleInfo.getOwnerSaleRating() + "</td>");
                    out.println("<td>" + userSaleInfo.getOwnerSaleReview() + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
                out.println("</div");
                out.println("</body>");
                out.println("</html>");
            }
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
        processRequest(request, response);
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
