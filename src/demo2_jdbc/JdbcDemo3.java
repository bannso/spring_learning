package demo2_jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_demo2_dbcp.xml")
public class JdbcDemo3 {
    /**
     *
     * @author XW
     *
     **/
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void demo2(){
        jdbcTemplate.update ("insert into account values (null ,?,?)","DBCP",102);
    }
}
