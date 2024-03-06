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
import model.MyUserFacade;

/**
 *
 * @author dzaky
 */
@WebServlet(name = "ViewAllProperty", urlPatterns = {"/ViewAllProperty"})
public class ViewAllProperty extends HttpServlet {

    @EJB
    private MyPropertyFacade myPropertyFacade;

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
                request.getRequestDispatcher("PropertyListings.jsp").include(request, response);

                List<MyProperty> allProperty = myPropertyFacade.findAvailableProperties();
                if (allProperty == null || allProperty.isEmpty()) {
                    throw new Exception();
                } else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<meta charset=\"UTF-8\">");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div id=\"container\">");
                    out.println("<h3>Available Property</h3>");
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>Listing ID</th>");
                    out.println("<th>Property Name</th>");
                    out.println("<th>Location</th>");
                    out.println("<th>Description</th>");
                    out.println("<th>Type</th>");
                    out.println("<th>Price</th>");
                    out.println("<th>Owned By</th>");

                    out.println("</tr>");

                    for (MyProperty allPropertyInfo : allProperty) {
                        out.println("<tr>");
                        out.println("<td>" + allPropertyInfo.getId() + "</td>");
                        out.println("<td>" + allPropertyInfo.getName() + "</td>");
                        out.println("<td>" + allPropertyInfo.getLocation() + "</td>");
                        out.println("<td>" + allPropertyInfo.getDescription() + "</td>");
                        out.println("<td>" + allPropertyInfo.getType() + "</td>");
                        out.println("<td>" + allPropertyInfo.getPrice() + "</td>");
                        out.println("<td>" + allPropertyInfo.getOwnedBy() + "</td>");

                        out.println("</tr>");
                    }

                    out.println("</table>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                }

            } catch (Exception e) {
                out.println("No existing property!");
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
