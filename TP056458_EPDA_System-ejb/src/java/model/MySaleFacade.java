/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dzaky
 */
@Stateless
public class MySaleFacade extends AbstractFacade<MySale> {

    @PersistenceContext(unitName = "TP056458_EPDA_System-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MySaleFacade() {
        super(MySale.class);
    }
    
    public List<MySale> findSalesByCustomer(String customerID) {
        TypedQuery<MySale> query = em.createQuery(
            "SELECT c FROM MySale c WHERE c.customerID = :customerID", MySale.class);
        query.setParameter("customerID", customerID);
        return query.getResultList();
    }
    
    public List<MySale> findSalesByOwner(String ownerID) {
        TypedQuery<MySale> query = em.createQuery(
            "SELECT o FROM MySale o WHERE o.ownerID = :ownerID", MySale.class);
        query.setParameter("ownerID", ownerID);
        return query.getResultList();
    }
    
}
