package com.xiyou.xiyoushopuser.service;

import com.xiyou.common.model.User;
import com.xiyou.xiyoushopuser.dao.UserDao;
import com.xiyou.xiyoushopuser.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserInfo(){
        return userDao.findUserInfo();
    }

    public void insertUserInfo(User user){
        userDao.insertUserInfo(user);
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public User findByUserId(int id){
        return userDao.findByUserId(id);
    }

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    /**
     * 查询所有用户的信息，根据userVO
     * @param userVo
     * @return
     */
    public List<User> queryUserByVo(UserVo userVo){
        return userDao.queryUserByVo(userVo);
    }

    /**
     * 根据指定id删除用户
     * @param id
     */
    public void deleteUserById(int id){
        userDao.deleteUserById(id);
    }

    /**
     * 根据用户名查询用户的相关信息
     * @param name
     * @return
     */
    public User findByUserName(String name){
        return userDao.findByUserName(name);
    }
}
