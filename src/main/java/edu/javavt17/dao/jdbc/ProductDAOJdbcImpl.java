package edu.javavt17.dao.jdbc;

import edu.javavt17.dao.ProductDAO;
import edu.javavt17.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOJdbcImpl implements ProductDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Product item) {
        if (item.getIdProduct() > 0) {
            // update
            System.out.println("Product update");
            String sql = "UPDATE product SET productName=?, manufacturer=? WHERE idProduct=?";
            jdbcTemplate.update(sql, item.getProductName(), item.getManufacturer());
        } else {
            // insert
            System.out.println("Product insert");
            String sql = "INSERT INTO product (productName, manufacturer)"
                    + " VALUES (?, ?)";
            jdbcTemplate.update(sql, item.getProductName(), item.getManufacturer());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM product WHERE idProduct=?";
        jdbcTemplate.update(sql, itemId);
    }

    public Product get(int itemId) {
        String sql = "SELECT * FROM product WHERE idProduct=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {

            public Product extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    return getProductFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<Product> list() {
        String sql = "SELECT * FROM product";
        List<Product> listProduct = jdbcTemplate.query(sql, new RowMapper<Product>() {

            public Product mapRow(ResultSet rs, int i) throws SQLException {

                return getProductFromDB(rs);
            }
        });
        return listProduct;
    }

    private Product getProductFromDB(ResultSet rs) throws SQLException{
        Product product = new Product();
        product.setIdProduct(rs.getInt("idProduct"));
        product.setProductName(rs.getString("productName"));
        product.setManufacturer(rs.getString("manufacturer"));
        return product;
    }
}
