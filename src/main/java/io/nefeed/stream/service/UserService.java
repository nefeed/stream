package io.nefeed.stream.service;

import io.nefeed.stream.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 16:55
 */
public interface UserService {

    /**
     * @param user
     *
     * @return
     */
    User login(User user);

    /**
     *
     * @return
     */
    List<User> findUser();

    /**
     * @param map
     *
     * @return
     */
    Long getTotalUser(Map<String, Object> map);

    /**
     * @param user
     *
     * @return
     */
    int updateUser(User user);

    /**
     * @param user
     *
     * @return
     */
    int addUser(User user);

    /**
     * @param id
     *
     * @return
     */
    int deleteUser(Integer id);
}

