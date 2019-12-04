package edu.javavt17.dao.jpa;

import edu.javavt17.dao.ProductDAO;
import edu.javavt17.model.Product;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDAOJpaImpl implements ProductDAO {
    @PersistenceContext
    private EntityManager em;

    public void saveOrUpdate(Product item) {
        if (item.getIdProduct() > 0) {
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

    public Product get(int itemId) {
        return em.find(Product.class, itemId);
    }

    public List<Product> list() {
        List<Product> products = em.createNamedQuery("Product.findAll",Product.class).getResultList();
        return products;
    }
}
