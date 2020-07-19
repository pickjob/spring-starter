package app.model.entity;

import java.util.Date;

/**
 * Table: user
 */
public class User {
    /**
     * Column: id
     */
    private Long id;

    /**
     * Column: account
     * Remark: 用户账户
     */
    private String account;

    /**
     * Column: password
     * Remark: 用户密码
     */
    private String password;

    /**
     * Column: create_time
     * Remark: 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}