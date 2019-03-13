package demo1_tx;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void transfer(final String from, final String to, final double money) {
        transactionTemplate.execute (new TransactionCallbackWithoutResult () {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //转账
                accountDao.outMoney (from,money);
                /*如果此处出现异常  会导致前者money减少  但是后者为增加*/
                int a = 1/0;
                accountDao.inMoney (to,money);
            }
        });
    }
}
