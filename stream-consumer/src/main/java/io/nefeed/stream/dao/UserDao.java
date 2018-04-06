package io.nefeed.stream.dao;

import io.nefeed.stream.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 16:56
 */
@Repository
public interface UserDao {

    /**
     * 登录
     *
     * @param user
     *
     * @return
     */
    User login(User user);

    /**
     * 查找用户列表
     *
     * @param map
     *
     * @return
     */
    List<User> findUsers(Map<String, Object> map);

    /**
     * @param map
     *
     * @return
     */
    Long getTotalUser(Map<String, Object> map);

    /**
     * 实体修改
     *
     * @param user
     *
     * @return
     */
    int updateUser(User user);

    /**
     * 添加用户
     *
     * @param user
     *
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     *
     * @param id
     *
     * @return
     */
    int deleteUser(Integer id);
}
