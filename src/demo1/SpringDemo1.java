package demo1;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_demo1.xml")
public class SpringDemo1 {
    /**
     *
     * @author XW
     *
     **/
    @Resource(name = "orderDao")
    private OrderDao orderDao;
    @Test
    public void test(){
        orderDao.delete ();
        orderDao.save ();
        orderDao.update ();
        orderDao.find ();
    }
}
