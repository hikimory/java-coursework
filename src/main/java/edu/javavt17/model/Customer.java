package edu.javavt17.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@NamedQuery(name = "Customer.findAll", query = "select c from Customer c")
public class Customer implements Serializable{
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idCustomer;
    @NotEmpty @Column(nullable=false)
    private String fullName;

    public int getId() {
        return idCustomer;
    }

    public void setId(int id) {
        this.idCustomer = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + idCustomer +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
