package app.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Table: permission
 */
//@ApiModel("权限表实体")
@Table(name = "permission")
@Entity
public class Permission {
    @GeneratedValue
    @Id
    private Long id;
//    @ApiModelProperty("权限代码")
    private String code;
//    @ApiModelProperty("权限名称")
    private String name;
//    @ApiModelProperty("创建时间")
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