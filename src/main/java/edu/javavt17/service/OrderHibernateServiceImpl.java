package edu.javavt17.service;

import edu.javavt17.dao.OrderDAO;
import edu.javavt17.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("orderHibernateService")
@Transactional(readOnly=false, value = "hibernateTransactionManager")
public class OrderHibernateServiceImpl implements OrderService{
    @Autowired
    @Qualifier("getOrderHibernateDAO")
    private OrderDAO orderDAO;

    public void saveOrUpdate(Order item) {
        orderDAO.saveOrUpdate(item);
    }
    public void delete(int itemId) {
        orderDAO.delete(itemId);
    }
    public Order get(int itemId) {
        return orderDAO.get(itemId);
    }
    public List<Order> list() {
        return orderDAO.list();
    }
}
