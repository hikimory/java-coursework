package edu.javavt17.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order")
@NamedQuery(name = "Order.findAll", query = "select o from Order o")
public class Order implements Serializable{
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;
    @Column private int productCount;
    @Column private int price;
}
