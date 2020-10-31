package spring.starter.data.rdms.entity;

import javax.persistence.*;

/**
 * Table: who_am_i
 */
@Table(name = "who_am_i")
@Entity
public class WhoAmI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}