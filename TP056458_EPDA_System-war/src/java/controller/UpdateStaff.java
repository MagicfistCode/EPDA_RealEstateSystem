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
import model.MyUser;
import model.MyUserFacade;
/**
 *
 * @author dzaky
 */
@WebServlet(name = "UpdateStaff", urlPatterns = {"/UpdateStaff"})
public class UpdateStaff extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            try {
                MyUser user = myUserFacade.find(username);
                String userRole = user.getUserrole();

                if (user == null) {
                    throw new Exception();
                }
                if ("Admin".equals(userRole)) {
                    if (!isEmpty(password)) {
                        user.setPassword(password);
                    }
                    if (!isEmpty(name)) {
                        user.setName(name);
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
                    myUserFacade.edit(user);
                    request.getRequestDispatcher("ManageStaff.jsp").include(request, response);
                    out.println("<div id=\"container\">");
                    out.println("Changes Saved!");
                    out.println("</div>");
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                request.getRequestDispatcher("ManageStaff.jsp").include(request, response);
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
