package edu.javavt17.dao;


import edu.javavt17.model.Order;
import java.util.List;

public interface OrderDAO {

    void saveOrUpdate(Order item);

    void delete(int itemId);

    Order get(int itemId);

    List<Order> list();
}
