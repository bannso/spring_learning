package demo3_tx;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    //继承 JdbcDaoSupport  省去每次设置JDBC模板及其set方法的过程，减少代码重复度
    //如果没有定义模板则会自动生成JDBC模板
    @Override
    public void outMoney(String from, double money) {
        this.getJdbcTemplate ().update ("update account set money=money-? where name =?",money,from);
    }

    @Override
    public void inMoney(String to, double money) {
        this.getJdbcTemplate ().update ("update account set money=money+? where name =?",money,to);
    }
}
