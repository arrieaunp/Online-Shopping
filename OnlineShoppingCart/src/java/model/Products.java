/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aunchisachanatipakul
 */
@Entity
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id"),
    @NamedQuery(name = "Products.findByMovie", query = "SELECT p FROM Products p WHERE p.movie = :movie"),
    @NamedQuery(name = "Products.findByRating", query = "SELECT p FROM Products p WHERE p.rating = :rating"),
    @NamedQuery(name = "Products.findByYearcreate", query = "SELECT p FROM Products p WHERE p.yearcreate = :yearcreate"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "MOVIE")
    private String movie;
    @Size(max = 20)
    @Column(name = "RATING")
    private String rating;
    @Size(max = 4)
    @Column(name = "YEARCREATE")
    private String yearcreate;
    @Column(name = "PRICE")
    private Integer price;

    public Products() {
    }

    public Products(Integer id) {
        this.id = id;
    }
    
    public Products(int id, String movie, String rating, String yearcreate, int price) {
        this.id = id;
        this.movie = movie;
        this.rating = rating;
        this.yearcreate = yearcreate;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYearcreate() {
        return yearcreate;
    }

    public void setYearcreate(String yearcreate) {
        this.yearcreate = yearcreate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Products[ id=" + id + " ]";
    }
    
}
