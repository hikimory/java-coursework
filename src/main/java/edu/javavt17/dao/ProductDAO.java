package edu.javavt17.dao;

import edu.javavt17.model.Product;

import java.util.List;

public interface ProductDAO {
    void saveOrUpdate(Product item);

    void delete(int itemId);

    Product get(int itemId);

    List<Product> list();
}
