package io.nefeed.stream.controller;

import com.alibaba.fastjson.JSON;
import io.nefeed.stream.aspect.AnalysisActuatorAspect;
import io.nefeed.stream.entity.User;
import io.nefeed.stream.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 16:58
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    /**
     * 日志文件
     */
    final static Logger log = LoggerFactory.getLogger(AnalysisActuatorAspect.class);

    /**
     * 登录
     *
     * @param user
     *
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            return "You have logined already, " + currentUser.getUserName() + "!";
        }
        User resultUser = userService.login(user);
        log.info("request: user/login , user: " + user.toString());
        if (resultUser == null) {
            return "login failed";
        } else {
            session.setAttribute("currentUser", resultUser);
            return "login success";
        }
    }

    /**
     * 退出系统
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        log.info("request: user/logout");
        return "logout success";
    }

    /**
     * 查找所有用户
     *
     */
    @RequestMapping("/list")
    @ResponseBody
    public String list(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "Please login first!";
        } else if ("超级管理员".equals(currentUser.getRoleName())) {
            return "You are not an admin!";
        }
        return JSON.toJSONString(userService.findUser());
    }
}