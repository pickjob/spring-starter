package app.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table: who_am_i
 */
//@ApiModel("当前数据库表实体")
@Table(name = "who_am_i")
@Entity
public class WhoAmI {
    @Id
    @GeneratedValue
    private Byte id;
//    @ApiModelProperty("当前数据库名称")
    private String name;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}