/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
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
@WebServlet(name = "ViewOwners", urlPatterns = {"/ViewOwners"})
public class ViewOwners extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                request.getRequestDispatcher("ManageOwners.jsp").include(request, response);

                List<MyUser> allUsers = myUserFacade.findAll(); // Retrieve all users from the database

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Customer Users</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div id=\"container\">");
                out.println("<h3>Owner Users</h3>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Username</th>");
                out.println("<th>Password</th>");
                out.println("<th>Name</th>");
                out.println("<th>Email</th>");
                out.println("<th>Phone</th>");
                out.println("<th>Gender</th>");
                out.println("<th>Balance</th>");
                out.println("<th>User Role</th>");

                // Add more table headers as needed
                out.println("</tr>");

                for (MyUser userInfo : allUsers) {
                    if ("Owner".equals(userInfo.getUserrole())) {
                        out.println("<tr>");
                        out.println("<td>" + userInfo.getId() + "</td>");
                        out.println("<td>" + userInfo.getPassword() + "</td>");
                        out.println("<td>" + userInfo.getName() + "</td>");
                        out.println("<td>" + userInfo.getEmail() + "</td>");
                        out.println("<td>" + userInfo.getPhone() + "</td>");
                        out.println("<td>" + userInfo.getGender() + "</td>");
                        out.println("<td>" + userInfo.getBalance() + "</td>");
                        out.println("<td>" + userInfo.getUserrole() + "</td>");

                        out.println("</tr>");
                    }
                }

                out.println("</table>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");

            } catch (Exception e) {
                out.println("<div id=\"container\">");
                out.println("There are no existing owners!");
                out.println("</div>");
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
