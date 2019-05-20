package com.xiyou.xiyoushopuser.mapper;

import com.xiyou.xiyoushopuser.model.User;
import com.xiyou.xiyoushopuser.vo.UserVo;

import java.util.List;

/**
 *
 */
public interface UserMapper {

    /**
     * 普通用户查看信息
     * @return
     */
    public User findUserInfo();

    /**
     * 插入数据，因为设置了<selectKey/>标签所以我们的user是放进了ID的。
     * @param user
     */
    public void insertUserInfo(User user);

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public User findByUserId(int id);

    /**
     * 更新用户
     * @param user
     */
    public void updateUser(User user);

    /**
     * 查询所有用户的信息，根据userVO
     * @param userVo
     * @return
     */
    public List<User> queryUserByVo(UserVo userVo);

    /**
     * 根据指定id删除用户
     * @param id
     */
    public void deleteUserById(int id);
}
