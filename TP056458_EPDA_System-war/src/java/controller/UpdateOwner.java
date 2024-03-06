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
import model.MyProperty;
import model.MyPropertyFacade;
import model.MySale;
import model.MySaleFacade;
import model.MyUser;
import model.MyUserFacade;

/**
 *
 * @author dzaky
 */
@WebServlet(name = "UpdateOwner", urlPatterns = {"/UpdateOwner"})
public class UpdateOwner extends HttpServlet {

    @EJB
    private MyPropertyFacade myPropertyFacade;

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String newbalance = request.getParameter("balance");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            try {
                MyUser user = myUserFacade.find(username);
                String userRole = user.getUserrole();

                List<MyProperty> property = myPropertyFacade.findAll();
                List<MySale> sale = mySaleFacade.findAll();

                String currentUser = user.getId();

                if (user == null) {
                    throw new Exception();
                }
                if ("Owner".equals(userRole)) {
                    if (!isEmpty(password)) {
                        user.setPassword(password);
                    }
                    if (!isEmpty(name)) {
                        user.setName(name);
                        for (MyProperty userProperty : property) {
                            if (currentUser.equals(userProperty.getOwnerID())) {
                                userProperty.setOwnedBy(name);
                                myPropertyFacade.edit(userProperty);
                            }
                        }

                        for (MySale userSale : sale) {
                            if (currentUser.equals(userSale.getOwnerID())) {
                                userSale.setPurchasedFrom(name);
                                mySaleFacade.edit(userSale);
                            }

                        }
                    }
                    if (!isEmpty(email)) {
                        user.setEmail(email);
                    }
                    if (!isEmpty(gender)) {
                        user.setGender(gender);
                    }
                    if (!isEmpty(phone)) {
                        if (phone.length() != 10) {
                            throw new Exception();
                        } else {
                            user.setPhone(phone);
                        }
                    }
                    if (!isEmpty(newbalance)) {
                        double balance = Double.parseDouble(newbalance);
                        if (balance <= 0) {
                            throw new Exception();
                        } else {
                            user.setBalance(balance);
                        }
                    }
                    myUserFacade.edit(user);
                    request.getRequestDispatcher("ManageOwners.jsp").include(request, response);
                    out.println("<div id=\"container\">");
                    out.println("Changes Saved!");
                    out.println("</div>");
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {
                request.getRequestDispatcher("ManageOwners.jsp").include(request, response);
                out.println("<div id=\"container\">");
                out.println("Wrong input!");
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
