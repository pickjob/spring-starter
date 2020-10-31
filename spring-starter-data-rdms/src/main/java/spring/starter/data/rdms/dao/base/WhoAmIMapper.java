package spring.starter.data.rdms.dao.base;

import spring.starter.data.rdms.entity.WhoAmI;

public interface WhoAmIMapper {
    int insert(WhoAmI record);
    WhoAmI selectByPrimaryKey(Long id);
}