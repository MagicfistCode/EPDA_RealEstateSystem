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
import model.MySale;
import model.MySaleFacade;
import model.MyUser;
import model.MyUserFacade;

/**
 *
 * @author dzaky
 */
@WebServlet(name = "Purchase", urlPatterns = {"/Purchase"})
public class Purchase extends HttpServlet {

    @EJB
    private MyUserFacade myUserFacade;

    @EJB
    private MySaleFacade mySaleFacade;

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

        HttpSession s = request.getSession(false);
        MyUser user = (MyUser) s.getAttribute("user");

        String ID = request.getParameter("listingID");
        Long listingID = Long.parseLong(ID);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            MyProperty property = myPropertyFacade.find(listingID);

            String ownerID = property.getOwnerID();

            MyUser owner = myUserFacade.find(ownerID);

            if (property == null) {
                request.getRequestDispatcher("PropertyListings.jsp").include(request, response);
                out.println("<div id=\"container\">");
                out.println("Property with ID " + listingID + " not found.");
                out.println("</div>");
            } else if (property.getRentedBy() != null) {
                request.getRequestDispatcher("PropertyListings.jsp").include(request, response);
                out.println("<div id=\"container\">");
                out.println("Property with ID " + listingID + " not found.");
                out.println("</div>");
            } else {
                try {
                    if (user.getBalance() <= property.getPrice()) {
                        throw new Exception();
                    }
                    MySale newSale = new MySale();
                    newSale.setPropertyID(property.getId());
                    newSale.setPropertyName(property.getName());
                    newSale.setLocation(property.getLocation());
                    newSale.setType(property.getType());
                    newSale.setDescription(property.getDescription());
                    newSale.setPrice(property.getPrice());
                    newSale.setOwnerID(property.getOwnerID());
                    newSale.setPurchasedFrom(property.getOwnedBy());
                    newSale.setCustomerID(user.getId());
                    newSale.setPurchasedBy(user.getName());
                    mySaleFacade.create(newSale);

                    double purchaseProperty = user.getBalance() - property.getPrice();
                    user.setBalance(purchaseProperty);
                    myUserFacade.edit(user);
                    
                    double ownerRecieve = owner.getBalance() + property.getPrice();
                    owner.setBalance(ownerRecieve);
                    myUserFacade.edit(owner);

                    myPropertyFacade.remove(property);
                    request.getRequestDispatcher("PropertyListings.jsp").include(request, response);
                    out.println("<div id=\"container\">");
                    out.println("Purchase Successful!");
                    out.println("</div>");
                } catch (Exception e) {
                    request.getRequestDispatcher("PropertyListings.jsp").include(request, response);
                    out.println("<div id=\"container\">");
                    out.println("Insufficient Balance! Your current balance is: " + user.getBalance());
                    out.println("</div>");
                    e.printStackTrace();
                }
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
