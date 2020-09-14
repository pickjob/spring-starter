package app.model.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Table: user
 */
//@ApiModel("用户表实体")
@Entity
public class User {
    @GeneratedValue
    @Id
    private Long id;
//    @ApiModelProperty("账户名")
    private String account;
//    @ApiModelProperty("用户密码")
    private String password;
//    @ApiModelProperty("创建时间")
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