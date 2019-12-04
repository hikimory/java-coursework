package edu.javavt17.service;

import edu.javavt17.dao.ProductDAO;
import edu.javavt17.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class ProductJdbcServiceImpl {
    @Autowired
    @Qualifier("getProductJdbcDAO")
    private ProductDAO productDAO;

    public void saveOrUpdate(Product item) {
        productDAO.saveOrUpdate(item);
    }
    public void delete(int itemId) {
        productDAO.delete(itemId);
    }
    public Product get(int itemId) {
        return productDAO.get(itemId);
    }
    public List<Product> list() {
        return productDAO.list();
    }
}
