package edu.javavt17.dao.jpa;

import edu.javavt17.dao.OrderDAO;
import edu.javavt17.model.Order;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderDAOJpaImpl implements OrderDAO{
    @PersistenceContext
    private EntityManager em;

    public void saveOrUpdate(Order item) {
        if (item.getIdOrder() > 0) {
            // update
            em.merge(item);
        } else {
            // insert
            em.persist(item);
        }
    }

    public void delete(int itemId) {
        em.remove(get(itemId));
    }

    public Order get(int itemId) {
        return em.find(Order.class, itemId);
    }

    public List<Order> list() {
        List<Order> orders = em.createNamedQuery("Order.findAll",Order.class).getResultList();
        return orders;
    }
}
