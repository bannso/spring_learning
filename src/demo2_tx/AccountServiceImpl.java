package demo2_tx;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String from, String to, double money) {
        //转账
        accountDao.outMoney (from,money);
        /*如果此处出现异常  会导致前者money减少  但是后者为增加*/
        int a = 1/0;
        accountDao.inMoney (to,money);
    }
}
