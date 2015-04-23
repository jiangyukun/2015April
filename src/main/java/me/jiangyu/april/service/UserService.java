package me.jiangyu.april.service;

import me.jiangyu.april.entity.User;
import me.jiangyu.april.persistence.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by jiangyukun on 4/23/15.
 */
@Service
@Transactional
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public void save(User user) {
        logger.info("save user" + user.getName());
        userDao.save(user);
    }
}
