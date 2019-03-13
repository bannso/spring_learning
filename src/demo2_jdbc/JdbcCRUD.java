package demo2_jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
* JDBC   的    CRUD 操作
*
* */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_demo2.xml")
public class JdbcCRUD {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void demo1(){
        jdbcTemplate.update ("insert into account values (null ,?,?)","啊啊",102);
    }
    @Test
    public void demo2(){
        //修改
        String name = "aaaas";
        double salary = 0.1;
        jdbcTemplate.update ("update account set name =?,money=? where id=?",name,salary,6);
    }
    @Test
    public void demo3(){
        //删除
        jdbcTemplate.update ("delete from account where id=?",7);
    }
    @Test
    public void demo4(){
        //查询
        String name = jdbcTemplate.queryForObject ("select name from account where id = ?",String.class,6);
        System.out.println (name);
    }
    @Test
    public void demo5(){
        //查询
        long count = jdbcTemplate.queryForObject ("select count(*) from account",Long.class);
        System.out.println (count);
    }
    @Test
    public void demo6(){
        //将查询到的结果封装到一个对象
        Account account = jdbcTemplate.queryForObject("select * from account where id = ?",new MyRowMapper (),5);
        System.out.println (account);
    }
    @Test
    public void demo7(){
        //查询多条记录，返回list
        List<Account> list = jdbcTemplate.query("select * from account where id <5",new MyRowMapper ());
        for (Account x:list
             ) {
            System.out.println (x);
        }
    }
    class MyRowMapper implements RowMapper<Account>{

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account ();
            account.setId (resultSet.getInt ("id"));
            account.setName (resultSet.getString ("name"));
            account.setMoney (resultSet.getDouble ("money"));
            return account;
        }
    }
}
