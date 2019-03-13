package demo2_jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

public class JdbcDemo1 {
    /**
     * JDBC 模板的使用
     * @author XW
     *
     **/
    @Test
    public void demo1(){
        //创建连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource ();
        dataSource.setDriverClassName ("com.mysql.jdbc.Driver");
        dataSource.setUrl ("jdbc:mysql:///spring_jdbc");
        dataSource.setUsername ("root");
        dataSource.setPassword ("qwer1234");
        //创建JDBC模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate (dataSource);
        jdbcTemplate.setDataSource (dataSource);
        jdbcTemplate.update ("insert into account values (null ,?,?)","aa",100d);
    }
}
