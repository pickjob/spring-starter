package app.dao;

import app.entity.ProductLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pickjob@126.com
 * @time 2019-05-06
 **/
@Mapper
public interface ProductLineDao {
    @Select("select * from productlines")
    List<ProductLine> listAllProductlines();
}