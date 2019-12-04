package edu.javavt17.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@NamedQuery(name = "Product.findAll", query = "select p from Product p")
public class Product implements Serializable{
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idProduct;
    @NotEmpty @Column(nullable=false)
    private String productName;
    @NotEmpty @Column(nullable=false)
    private String manufacturer;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", productName='" + productName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
