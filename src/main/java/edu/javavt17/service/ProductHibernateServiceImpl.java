package edu.javavt17.service;

import edu.javavt17.dao.ProductDAO;
import edu.javavt17.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("productHibernateService")
@Transactional(readOnly=false, value = "hibernateTransactionManager")
public class ProductHibernateServiceImpl implements ProductService{
    @Autowired
    @Qualifier("getProductHibernateDAO")
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
