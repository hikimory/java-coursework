package edu.javavt17.dao.hibernate;

import edu.javavt17.dao.ProductDAO;
import edu.javavt17.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDAOHibernateImpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(Product item) {
        if (item.getIdProduct() > 0) {
            //update
            getCurrentSession().merge(item);
        } else {
            //insert
            getCurrentSession().save(item);
        }

    }

    public void delete(int itemId) {
        Product product = get(itemId);
        if (product != null)
            getCurrentSession().delete(product);
    }

    public Product get(int itemId) {
        Product product = (Product) getCurrentSession().get(Product.class, itemId);

        return product;
    }

    public List<Product> list() {
        Criteria criteria = getCurrentSession().createCriteria(Product.class);

        return criteria.list();
    }
}
