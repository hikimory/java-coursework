package edu.javavt17.dao.hibernate;

import edu.javavt17.dao.OrderDAO;
import edu.javavt17.model.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDAOHibernateImpl implements OrderDAO{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(Order item) {
        if (item.getIdOrder() > 0) {
            //update
            getCurrentSession().merge(item);
        } else {
            //insert
            getCurrentSession().save(item);
        }

    }

    public void delete(int itemId) {
        Order order = get(itemId);
        if (order != null)
            getCurrentSession().delete(order);
    }

    public Order get(int itemId) {
        Order order = (Order) getCurrentSession().get(Order.class, itemId);

        return order;
    }

    public List<Order> list() {
        Criteria criteria = getCurrentSession().createCriteria(Order.class);

        return criteria.list();
    }
}
