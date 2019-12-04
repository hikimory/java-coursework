package edu.javavt17.dao.jdbc;

import edu.javavt17.dao.OrderDAO;
import edu.javavt17.dao.ProductDAO;
import edu.javavt17.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOJdbcImpl implements OrderDAO {
    @Autowired
    @Qualifier("getProductJdbcDAO")
    private ProductDAO prodactDAO;

    private JdbcTemplate jdbcTemplate;
    public OrderDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Order item) {
        if (item.getIdOrder() > 0) {
            // update
            System.out.println("Order update");
            String sql = "UPDATE order SET idProduct=?, productCount=?, price=? WHERE idOrder=?";
            jdbcTemplate.update(sql, item.getIdProduct(), item.getProductCount(), item.getPrice());
        } else {
            // insert
            System.out.println("Customer insert");
            String sql = "INSERT INTO order (idProduct, productCount, price)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, item.getIdProduct(), item.getProductCount(), item.getPrice());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM order WHERE idOrder=?";
        jdbcTemplate.update(sql, itemId);
    }

    public Order get(int itemId) {
        String sql = "SELECT * FROM order WHERE idOrder=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Order>() {

            public Order extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    return getOrderFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<Order> list() {
        String sql = "SELECT * FROM order";
        List<Order> listOrder = jdbcTemplate.query(sql, new RowMapper<Order>() {

            public Order mapRow(ResultSet rs, int i) throws SQLException {

                return getOrderFromDB(rs);
            }
        });
        return listOrder;
    }

    private Order getOrderFromDB(ResultSet rs) throws SQLException{
        Order order = new Order();
        order.setIdOrder(rs.getInt("idOrder"));
        order.setIdProduct(rs.getInt("idProduct"));
        order.setProduct(prodactDAO.get(rs.getInt("idProduct")));
        order.setProductCount(rs.getInt("productCount"));
        order.setPrice(rs.getInt("price"));
        return order;
    }
}
