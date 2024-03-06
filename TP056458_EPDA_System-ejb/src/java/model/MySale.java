/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author dzaky
 */
@Entity
public class MySale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long propertyID;
    private String propertyName;
    private String location;
    private String type;
    private String description;
    private double price;
    private String ownerID;
    private String purchasedFrom;
    private String customerID;
    private String purchasedBy;
    private int customerSaleRating;
    private int ownerSaleRating;
    private String customerSaleReview;
    private String ownerSaleReview;
    

    public MySale(Long id, Long propertyID, String propertyName, String location, String type, String description, double price, String ownerID, String purchasedFrom, String customerID, String purchasedBy, int customerSaleRating, int ownerSaleRating, String customerSaleReview, String ownerSaleReview) {
        this.id = id;
        this.propertyID = propertyID;
        this.propertyName = propertyName;
        this.location = location;
        this.type = type;
        this.description = description;
        this.price = price;
        this.ownerID = ownerID;
        this.purchasedFrom = purchasedFrom;
        this.customerID = customerID;
        this.purchasedBy = purchasedBy;
        this.customerSaleRating = customerSaleRating;
        this.ownerSaleRating = ownerSaleRating;
        this.customerSaleReview = customerSaleReview;
        this.ownerSaleReview = ownerSaleReview;
    }

    public MySale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Long propertyID) {
        this.propertyID = propertyID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getPurchasedFrom() {
        return purchasedFrom;
    }

    public void setPurchasedFrom(String purchasedFrom) {
        this.purchasedFrom = purchasedFrom;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPurchasedBy() {
        return purchasedBy;
    }

    public void setPurchasedBy(String purchasedBy) {
        this.purchasedBy = purchasedBy;
    }

    public int getCustomerSaleRating() {
        return customerSaleRating;
    }

    public void setCustomerSaleRating(int customerSaleRating) {
        this.customerSaleRating = customerSaleRating;
    }

    public int getOwnerSaleRating() {
        return ownerSaleRating;
    }

    public void setOwnerSaleRating(int ownerSaleRating) {
        this.ownerSaleRating = ownerSaleRating;
    }

    public String getCustomerSaleReview() {
        return customerSaleReview;
    }

    public void setCustomerSaleReview(String customerSaleReview) {
        this.customerSaleReview = customerSaleReview;
    }

    public String getOwnerSaleReview() {
        return ownerSaleReview;
    }

    public void setOwnerSaleReview(String ownerSaleReview) {
        this.ownerSaleReview = ownerSaleReview;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MySale)) {
            return false;
        }
        MySale other = (MySale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MySale[ id=" + id + " ]";
    }

}
