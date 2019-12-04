package edu.javavt17.service;

import edu.javavt17.dao.ProductDAO;
import edu.javavt17.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class ProductJpaServiceImpl {
    @Autowired
    @Qualifier("getProductJpaDAO")
    private ProductDAO productDAO;

    public List<Product> list() {
        return productDAO.list();
    }
    public Product get(int itemId) {
        return productDAO.get(itemId);
    }
    public void saveOrUpdate(Product item) {
        productDAO.saveOrUpdate(item);
    }
    public void delete(int itemId) {
        productDAO.delete(itemId);
    }
}
