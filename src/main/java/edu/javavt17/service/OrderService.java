package edu.javavt17.service;

import edu.javavt17.model.Order;
import java.util.List;

public interface OrderService {
    void saveOrUpdate(Order item);
    void delete(int itemId);
    Order get(int itemId);
    List<Order> list();
}

