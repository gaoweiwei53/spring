package org.example.service;

import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService{
//    private UserDao userDao = new UserDaoImpl();

    // 增加新的实现类后，需要在service层更改new的对象，更改了原有代码，增加新的实现类总是要需修改Service层的代码
//    private UserDao userDao = new UserDaoMysqlImpl();

    // 使用下面的方式更好
    // 利用set方法进行动态实现值的注入
    // 不用在这里new对象了，可交给用户自己传入
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser(){
        userDao.getUser();
    }
}
