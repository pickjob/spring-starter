package app.model.entity;

/**
 * Table: who_am_i
 */
public class WhoAmI {
    /**
     * Column: id
     */
    private Byte id;

    /**
     * Column: name
     * Remark: 当前数据库名称
     */
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