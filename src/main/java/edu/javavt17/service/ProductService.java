package edu.javavt17.service;

import edu.javavt17.model.Product;
import java.util.List;

public interface ProductService {
    void saveOrUpdate(Product item);
    void delete(int itemId);
    Product get(int itemId);
    List<Product> list();
}
