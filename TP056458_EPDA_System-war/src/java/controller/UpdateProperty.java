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
import model.MyProperty;
import model.MyPropertyFacade;
import model.MyUser;
import model.MyUserFacade;

/**
 *
 * @author dzaky
 */
@WebServlet(name = "UpdateProperty", urlPatterns = {"/UpdateProperty"})
public class UpdateProperty extends HttpServlet {

    @EJB
    private MyUserFacade myUserFacade;

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

        String ID = request.getParameter("listingID");
        Long listingID = Long.parseLong(ID);

        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String price = request.getParameter("price");


        HttpSession s = request.getSession(false);
        MyUser user = (MyUser) s.getAttribute("user");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            MyProperty property = myPropertyFacade.find(listingID);
            String currentOwner = user.getId();

            if (property == null) {
                request.getRequestDispatcher("ManageProperty.jsp").include(request, response);
                out.println("<div id=\"container\">");
                out.println("Property with ID " + listingID + " not found.");
                out.println("</div>");
            } else {
                try {
                    if (!currentOwner.equals(property.getOwnerID())) {
                        throw new Exception();
                    }
                    if (!isEmpty(name)) {
                        property.setName(name);
                    }
                    if (!isEmpty(description)) {
                        property.setDescription(description);
                    }
                    if (!isEmpty(location)) {
                        property.setLocation(location);
                    }
                    if (!"".equals(type)) {
                        property.setType(type);
                    }
                    if (!isEmpty(price)) {
                        double newPrice = Double.parseDouble(price);
                        if (newPrice > 0) {
                            property.setPrice(newPrice);
                        } else {
                            throw new Exception();
                        }
                    }
                    myPropertyFacade.edit(property);
                    request.getRequestDispatcher("ManageProperty.jsp").include(request, response);
                    out.println("<div id=\"container\">");
                    out.println("Property ID " + listingID + " has been updated!");
                    out.println("</div>");
                } catch (Exception e) {
                    request.getRequestDispatcher("ManageProperty.jsp").include(request, response);
                    out.println("<div id=\"container\">");
                    out.println("Wrong Input!");
                    out.println("</div>");
                    e.printStackTrace();
                }
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
