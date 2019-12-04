package edu.javavt17.config;

import edu.javavt17.dao.OrderDAO;
import edu.javavt17.dao.ProductDAO;
import edu.javavt17.dao.jdbc.OrderDAOJdbcImpl;
import edu.javavt17.dao.jdbc.ProductDAOJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public OrderDAO getOrderJdbcDAO() {
        return new OrderDAOJdbcImpl(dataSource);
    }
    @Bean
    public ProductDAO getProductJdbcDAO() {
        return new ProductDAOJdbcImpl(dataSource);
    }
}
