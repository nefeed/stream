package io.nefeed.stream.service;

import com.alibaba.dubbo.config.annotation.Service;
import io.nefeed.stream.annotation.AnalysisActuator;
import io.nefeed.stream.dao.UserDao;
import io.nefeed.stream.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 16:56
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @AnalysisActuator(note = "登录校验")
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    @AnalysisActuator(note = "查找用户")
    @Override
    public List<User> findUser() {
        return userDao.findUsers(new HashMap<>(16));
    }

    @Override
    public int updateUser(User user) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if ("admin".equals(user.getUserName())) {
            return 0;
        }
        return userDao.updateUser(user);
    }

    @Override
    public Long getTotalUser(Map<String, Object> map) {
        return userDao.getTotalUser(map);
    }

    @Override
    public int addUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || getTotalUser(null) > 90) {
            return 0;
        }
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if (2 == id) {
            return 0;
        }
        return userDao.deleteUser(id);
    }

}