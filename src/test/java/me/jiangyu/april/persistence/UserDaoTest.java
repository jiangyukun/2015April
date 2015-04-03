package me.jiangyu.april.persistence;

import me.jiangyu.april.core.AbstractTestNGTest;
import me.jiangyu.april.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by jyk on 2015/4/3.
 */
public class UserDaoTest extends AbstractTestNGTest {
    @Autowired
    private UserDao userDao;

    @BeforeMethod
    public void startTransaction() {
    }

    @AfterMethod
    public void closeTransaction() {
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setId("1");
        user.setName("1");
        userDao.save(user);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId("1");
        user.setName("11");
        userDao.update(user);
    }

    @Test
    public void testRemove() throws Exception {
        User user = new User();
        user.setId("1");
        user.setName("11");
        userDao.remove(user);
    }
}