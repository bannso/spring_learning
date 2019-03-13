package demo1_tx;

public interface AccountDao {
    /**
     *
     * @author XW
     *
     **/
    public void outMoney(String from,double money);
    public void inMoney(String to,double money);
}
