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
public class MyPropertyFacade extends AbstractFacade<MyProperty> {

    @PersistenceContext(unitName = "TP056458_EPDA_System-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyPropertyFacade() {
        super(MyProperty.class);
    }

    public List<MyProperty> findPropertiesByOwner(String ownerId) {
        TypedQuery<MyProperty> query = em.createQuery(
                "SELECT p FROM MyProperty p WHERE p.ownerID = :ownerId", MyProperty.class);
        query.setParameter("ownerId", ownerId);
        return query.getResultList();
    }

    public List<MyProperty> findAvailableProperties() {
        TypedQuery<MyProperty> query = em.createQuery(
                "SELECT p FROM MyProperty p WHERE p.renterID IS NULL", MyProperty.class);
        return query.getResultList();
    }


}
