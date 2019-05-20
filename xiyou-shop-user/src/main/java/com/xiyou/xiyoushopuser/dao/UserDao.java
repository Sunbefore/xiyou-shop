package com.xiyou.xiyoushopuser.dao;

import com.xiyou.xiyoushopuser.mapper.UserMapper;
import com.xiyou.xiyoushopuser.model.User;
import com.xiyou.xiyoushopuser.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public User findUserInfo(){
        return userMapper.findUserInfo();
    }

    public void insertUserInfo(User user){
        userMapper.insertUserInfo(user);
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public User findByUserId(int id){
        return userMapper.findByUserId(id);
    }

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    /**
     * 查询所有用户的信息，根据userVO
     * @param userVo
     * @return
     */
    public List<User> queryUserByVo(UserVo userVo){
        return userMapper.queryUserByVo(userVo);
    }

    /**
     * 根据指定id删除用户
     * @param id
     */
    public void deleteUserById(int id){
        userMapper.deleteUserById(id);
    }
}
