package app.model.entity;

import java.util.Date;

/**
 * Table: permission
 */
public class Permission {
    /**
     * Column: id
     */
    private Long id;

    /**
     * Column: code
     * Remark: 权限代码
     */
    private String code;

    /**
     * Column: name
     * Remark: 权限名称
     */
    private String name;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}