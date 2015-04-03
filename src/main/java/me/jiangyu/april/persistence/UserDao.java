package me.jiangyu.april.persistence;

import me.jiangyu.april.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by jyk on 2015/4/3.
 */
@Repository
@Transactional
public class UserDao {
    @PersistenceContext(unitName = "test")
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void remove(User user) {
        entityManager.remove(user);
    }
}
