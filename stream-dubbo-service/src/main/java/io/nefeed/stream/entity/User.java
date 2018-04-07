package io.nefeed.stream.entity;

import java.io.Serializable;

/**
 * 用户表
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 15:36
 */
public class User implements Serializable {

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password="
                + password + ", roleName=" + roleName + "]";
    }

    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * Default 普通管理员
     */
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
