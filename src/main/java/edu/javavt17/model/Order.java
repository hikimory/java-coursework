package edu.javavt17.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order")
@NamedQuery(name = "Order.findAll", query = "select o from Order o")
public class Order implements Serializable{
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idOrder;

    @Column(insertable = false, updatable = false)
    private int idProduct;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    @Column private int productCount;
    @Column private int price;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idProduct=" + idProduct +
                ", product=" + product +
                ", productCount=" + productCount +
                ", price=" + price +
                '}';
    }
}
