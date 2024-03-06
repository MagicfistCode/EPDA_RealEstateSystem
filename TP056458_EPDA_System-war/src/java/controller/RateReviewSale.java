/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RateReviewSale", urlPatterns = {"/RateReviewSale"})
public class RateReviewSale extends HttpServlet {

    @EJB
    private MySaleFacade mySaleFacade;

    @EJB
    private MyUserFacade myUserFacade;

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

        String ID = request.getParameter("saleID");
        String rating = request.getParameter("rating");
        String feedback = request.getParameter("feedback");

        Long saleID = Long.parseLong(ID);

        HttpSession s = request.getSession(false);
        MyUser user = (MyUser) s.getAttribute("user");

        String userRole = user.getUserrole();
        String targetPage = "";

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            MySale saleInfo = mySaleFacade.find(saleID);
            String saleUser = user.getId();

            if ("Customer".equals(userRole)) {
                targetPage = "CustomerSaleHistory.jsp";
            } else {
                targetPage = "OwnerSaleHistory.jsp";
            }

            try {

                if (saleInfo != null) {
                    if ("Customer".equals(userRole)) {
                        if (!saleUser.equals(saleInfo.getCustomerID())) {
                            throw new Exception();
                        } else {
                            if (!isEmpty(rating)) {
                                int saleRating = Integer.parseInt(rating);
                                saleInfo.setCustomerSaleRating(saleRating);
                            }
                            if (!isEmpty(feedback)) {
                                saleInfo.setCustomerSaleReview(feedback);
                            }
                        }

                    } else if ("Owner".equals(userRole)) {
                        if (!saleUser.equals(saleInfo.getOwnerID())) {
                            throw new Exception();
                        } else {
                            if (!isEmpty(rating)) {
                                int saleRating = Integer.parseInt(rating);
                                saleInfo.setOwnerSaleRating(saleRating);
                            }
                            if (!isEmpty(feedback)) {
                                saleInfo.setOwnerSaleReview(feedback);
                            }
                        }

                    }
                    mySaleFacade.edit(saleInfo);
                    request.getRequestDispatcher(targetPage).include(request, response);
                    out.println("<div id=\"container\">");
                    out.println("Your Rating and Review has been saved!");
                    out.println("</div>");
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                request.getRequestDispatcher(targetPage).include(request, response);
                out.println("<div id=\"container\">");
                out.println("Sale ID not found!");
                out.println("</div>");

            }
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
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
