package com.bookstore.service.serviceImp;

import com.bookstore.Dao.DaoImp.userDaoImp;
import com.bookstore.Dao.userDao;
import com.bookstore.entity.User;
import com.bookstore.service.userService;

import java.util.List;

public class userServiceImp implements userService {
    userDao userDao=new userDaoImp();


    @Override
    public int update(User user, String userId) throws Exception {
        try
        {
            return userDao.update(user,userId);
        }catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public User findById(String userId) throws Exception {
        try
        {
            return userDao.findById(userId);
        }catch (Exception ex)
        {
            throw ex;
        }
    }

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int save(User user) throws Exception {
        try
        {
            return userDao.register(user);
        }catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public int manageSave(User user) throws Exception {
        try
        {
            return userDao.manageSave(user);
        }catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public User login(String name, String password) throws Exception {
        try
        {
            return userDao.login(name,password);
        }catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public int delete(String userId) throws Exception {
        try
        {
            return userDao.delete(userId);

        }catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public List<User> getUsers() throws Exception {
        try
        {
            return userDao.getUsers();
        }catch (Exception ex)
        {
            throw ex;
        }
    }

    @Override
    public long getUserRowCount() throws Exception {
        try
        {

        }catch (Exception ex)
        {
            throw ex;
        }
        return 0;
    }

    @Override
    public User findByLoginname(String loginname) throws Exception {
        try
        {
            return  userDao.findByLoginname(loginname);
        }catch (Exception ex)
        {
            throw ex;
        }

    }
}
