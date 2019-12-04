package edu.javavt17.service;

import edu.javavt17.dao.OrderDAO;
import edu.javavt17.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("orderJpaService")
@Transactional(readOnly=false, value = "jpaTransactionManager")
public class OrderJpaServiceImpl {
    @Autowired
    @Qualifier("getOrderJpaDAO")
    private OrderDAO orderDAO;

    public List<Order> list() {
        return orderDAO.list();
    }
    public Order get(int itemId) {
        return orderDAO.get(itemId);
    }
    public void saveOrUpdate(Order item) {
        orderDAO.saveOrUpdate(item);
    }
    public void delete(int itemId) {
        orderDAO.delete(itemId);
    }
}
